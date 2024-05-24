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

public class registration_Activity extends AppCompatActivity implements View.OnClickListener {

    Button registerButton;
    TextView registerSetText;
    TextView registerPageToLoginPage;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        registerButton=findViewById(R.id.registerButtonId);
        registerSetText=findViewById(R.id.registerSetTextViewId);
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
            Toast.makeText(this, "Register button clicked", Toast.LENGTH_SHORT).show();
        }

    }
}