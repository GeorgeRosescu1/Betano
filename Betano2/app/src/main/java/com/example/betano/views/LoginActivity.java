package com.example.betano.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button loginBtn;
    TextView signUpBtn, displatTxt;
    ProgressBar progressBar;
    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress_bar);
        signUpBtn = findViewById(R.id.signup_txt);
        loginBtn = findViewById(R.id.btn_login);
        final EditText editTextMail = findViewById(R.id.login_mail);
        final EditText editTextPass = findViewById(R.id.login_pass);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String myEmail;
                final String myPass;
                valid = true;
                myEmail = editTextMail.getText().toString();
                myPass = editTextPass.getText().toString();
                if (myEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(myEmail).matches()) {
                    editTextMail.setError("enter a valid email address");
                    valid = false;
                } else {
                    editTextMail.setError(null);
                }
                if (myPass.isEmpty() || myPass.length() < 4 || myPass.length() > 10) {
                    editTextPass.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    editTextPass.setError(null);
                }
                if (valid == true) {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(myEmail, myPass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "FailAuth", Toast.LENGTH_LONG).show();
                                    } else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        progressBar.setVisibility(View.VISIBLE);
                                        finish();
                                    }
                                }


                            });
                }
            }
        });
    }
}
