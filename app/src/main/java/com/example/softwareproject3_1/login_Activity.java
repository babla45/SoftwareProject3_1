package com.example.softwareproject3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_Activity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    EditText emailEditText, passwordEditText;
    TextView setTextTextView, registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.loginButtonId);

        emailEditText=findViewById(R.id.emailEditTextId);
        passwordEditText=findViewById(R.id.passwordEditTextId);

        setTextTextView=findViewById(R.id.loginPageSetTextViewId);
        registerTextView=findViewById(R.id.signUpTextViewId);

        loginButton.setOnClickListener(this);
        registerTextView.setOnClickListener(this);

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
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show();
        }
    }
}