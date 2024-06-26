package com.example.softwareproject3_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class blog extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BlogPostAdapter blogPostAdapter;
    private DatabaseReference databaseReference;
    private List<BlogPost> blogPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("blogPosts");

        blogPosts = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                blogPosts.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    BlogPost blogPost = snapshot.getValue(BlogPost.class);
                    blogPosts.add(blogPost);
                }
                blogPostAdapter = new BlogPostAdapter(blogPosts);
                recyclerView.setAdapter(blogPostAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("blog", "Error fetching data", databaseError.toException());
            }
        });

        // Handle the click event of the contribute button
        Button contributeButton = findViewById(R.id.contributeButton);
        contributeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blog.this, AddBlog.class);
                startActivity(intent);
            }
        });
    }
}
