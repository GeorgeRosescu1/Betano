package com.example.betano.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.example.betano.models.Admin;
import com.example.betano.models.Employee;
import com.example.betano.models.Gambler;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "Regs";
    Button signUpBtn;
    EditText email, pass, firstName, lastName, age;
    Spinner userType;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference referenceU;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        signUpBtn = findViewById(R.id.sign_up_btn);
        email = findViewById(R.id.email_register);
        pass = findViewById(R.id.pass_register);
        firstName = findViewById(R.id.first_name_register);
        lastName = findViewById(R.id.last_name_register);
        age = findViewById(R.id.age_register);
        userType = findViewById(R.id.type_spinner);
        referenceU = FirebaseDatabase.getInstance().getReference().child("User");



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailT, passT, firstNameT, lastNameT, ageT, userTypeT;
                emailT = email.getText().toString();
                passT = pass.getText().toString();
                firstNameT = firstName.getText().toString();
                lastNameT = lastName.getText().toString();
                ageT = age.getText().toString();
                userTypeT = userType.getSelectedItem().toString();
                progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);

                if (userTypeT.equals("Gambler")) {
                    Gambler gambler = new Gambler();

                    gambler.setUserType("Gambler");
                    gambler.setFirstName(firstNameT);
                    gambler.setLastName(lastNameT);
                    gambler.setAge(Integer.valueOf(ageT));
                    gambler.setEmail(emailT);
                    referenceU.push().setValue(gambler);
                } else if (userTypeT.equals("Employee")) {
                    Employee employee = new Employee();

                    employee.setUserType("Employee");
                    employee.setFirstName(firstNameT);
                    employee.setLastName(lastNameT);
                    employee.setAge(Integer.valueOf(ageT));
                    employee.setEmail(emailT);
                    employee.setSalary(2400);
                    referenceU.push().setValue(employee);
                } else if (userTypeT.equals("Admin")) {
                    Admin admin = new Admin();

                    admin.setUserType("Admin");
                    admin.setFirstName(firstNameT);
                    admin.setLastName(lastNameT);
                    admin.setAge(Integer.valueOf(ageT));
                    admin.setEmail(emailT);
                    referenceU.push().setValue(admin);
                } else {
                    Log.w(TAG, "Unknown user type", new Exception());
                }
                if (emailT != null && passT != null) {
                    auth.createUserWithEmailAndPassword(emailT, passT)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = auth.getCurrentUser();
                                        progressDialog.dismiss();
                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());


                                    }

                                    // ...
                                }
                            });
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
        return true;
    }
}
