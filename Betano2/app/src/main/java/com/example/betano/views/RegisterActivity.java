package com.example.betano.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
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
    Button backBtn, signUpBtn;
    EditText email, pass, firstName, lastName, age;
    Spinner userType;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference referenceG, referenceA, referenceE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backBtn = findViewById(R.id.back_btn);
        signUpBtn = findViewById(R.id.sign_up_btn);
        email = findViewById(R.id.email_register);
        pass = findViewById(R.id.pass_register);
        firstName = findViewById(R.id.first_name_register);
        lastName = findViewById(R.id.last_name_register);
        age = findViewById(R.id.age_register);
        userType = findViewById(R.id.type_spinner);
        referenceG = FirebaseDatabase.getInstance().getReference().child("Gambler");
        referenceA = FirebaseDatabase.getInstance().getReference().child("Admin");
        referenceE = FirebaseDatabase.getInstance().getReference().child("Employee");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
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
                if (userTypeT.equals("Gambler")) {
                    Gambler gambler = new Gambler();

                    gambler.setFirstName(firstNameT);
                    gambler.setLastName(lastNameT);
                    gambler.setAge(Integer.valueOf(ageT));
                    gambler.setEmail(emailT);
                    gambler.setPassword(passT);
                    referenceG.push().setValue(gambler);
                }
                if (emailT != null && passT != null) {
                    auth.createUserWithEmailAndPassword(emailT, passT)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = auth.getCurrentUser();
                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
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
}
