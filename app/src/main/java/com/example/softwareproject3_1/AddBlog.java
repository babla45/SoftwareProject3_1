package com.example.softwareproject3_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  AddBlog  extends AppCompatActivity {

    private EditText titleEditText, contentEditText, subjectEditText;
    private DatabaseReference databaseReference;
    public parent observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blog);


        // Initialize Firebase Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("blogPosts");

        // Initialize UI components
        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        subjectEditText = findViewById(R.id.subjectEditText);
        Button addButton = findViewById(R.id.addButton);


        // Set click listener for Add button
        addButton.setOnClickListener(v -> addBlogPost());
    }

    private void addBlogPost() {
        // Get input from EditText fields
        String title = titleEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();
        String subject = subjectEditText.getText().toString().trim();
         observable = parent.getInstance();

        // Check if any field is empty
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content) || TextUtils.isEmpty(subject)) {
            Toast.makeText(AddBlog.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create BlogPost object with input data
        BlogPost blogPost = new BlogPost(title, content, subject);

        // Push BlogPost object to Firebase Realtime Database
        databaseReference.push().setValue(blogPost)
                .addOnSuccessListener(aVoid -> {
                    // Blog post added successfully
                    Toast.makeText(AddBlog.this, "Blog post added successfully!", Toast.LENGTH_SHORT).show();
                    // Clear EditText fields
                    titleEditText.setText("");
                    contentEditText.setText("");
                    subjectEditText.setText("");
                    observable.notifyChildObservers(); // Notify observers
                    Intent intent = new Intent(AddBlog.this, NotificationActivity.class);
                    Log.d("AddBlog", "Title passed to NotificationActivity: " + title);

                    startActivity(intent);

                })
                .addOnFailureListener(e -> {
                    // Failed to add blog post
                    Toast.makeText(AddBlog.this, "Failed to add blog post: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
