package com.example.softwareproject3_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_Activity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    EditText emailEditText, passwordEditText;
    TextView setTextTextView, registerTextView;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);

        firebaseAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.loginProgressBarId);
        loginButton=findViewById(R.id.loginButtonId);

        emailEditText=findViewById(R.id.emailEditTextId);
        passwordEditText=findViewById(R.id.passwordEditTextId);

        setTextTextView=findViewById(R.id.loginPageSetTextViewId);
        registerTextView=findViewById(R.id.signUpTextViewId);

        loginButton.setOnClickListener(this);
        registerTextView.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        firebaseAuth.signOut();
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signUpTextViewId)
        {
            Intent intent=new Intent(login_Activity.this, registration_Activity.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.loginButtonId)
        {
//            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show();
            userLogin();
        }
    }



    private void userLogin() {
        String emailId = emailEditText.getText().toString().trim();
        String userPassword = passwordEditText.getText().toString();

        if (emailId.isEmpty()) {
            emailEditText.setError("Please enter your email address");
            emailEditText.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            emailEditText.setError("Please enter a valid email address");
            emailEditText.requestFocus();
            return;
        }
        if (userPassword.isEmpty()) {
            passwordEditText.setError("Please enter your password");
            passwordEditText.requestFocus();
            return;
        }

        if (userPassword.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            passwordEditText.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);


        firebaseAuth.signInWithEmailAndPassword(emailId, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    Toast.makeText(login_Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login_Activity.this, NavigationDrawer.class));
                } else {
//                    Toast.makeText(login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    setTextTextView.setText("Login Failed! Check your credentials.\nMake sure you have an account and check your internet connection");
                }

            }
        });
    }

}