package com.example.softwareproject3_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration_Activity extends AppCompatActivity implements View.OnClickListener {

    Button registerButton;
    TextView registerMessage;
    TextView registerPageToLoginPage;
    EditText email,password;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        firebaseAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.registerProgressBarId);

        registerButton=findViewById(R.id.registerButtonId);
        registerMessage=findViewById(R.id.messageId);

        registerPageToLoginPage=findViewById(R.id.loginTextViewId);

        email=findViewById(R.id.emailEditTextId);
        password=findViewById(R.id.passwordEditTextId);

        registerButton.setOnClickListener(this);
        registerPageToLoginPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.loginTextViewId)
        {
            Intent intent=new Intent(registration_Activity.this, login_Activity.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.registerButtonId)
        {
            registerUser();
        }

    }

    private void registerUser() {
        String emailId=email.getText().toString().trim();
        String userPassword=password.getText().toString();




        if (emailId.isEmpty()) {
            email.setError("Please enter your email address");
            email.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            email.setError("Please enter a valid email address");
            email.requestFocus();
            return;
        }

        if (userPassword.isEmpty()) {
            password.setError("Please enter your password");
            password.requestFocus();
            return;
        }

        if (userPassword.length() < 6) {
            password.setError("Password must be at least 6 characters");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        startActivity(new Intent(registration_Activity.this,login_Activity.class));

        firebaseAuth.createUserWithEmailAndPassword(emailId, userPassword ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Toast.makeText(registration_Activity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(registration_Activity.this,login_Activity.class));
                }
                else
                {
                    Toast.makeText(registration_Activity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
//                    registerSetText.setText("Registration Unsuccessful");
                    registerMessage.setText("Registration Failed! Please check your internet connection");
                }


            }
        });


    }
}