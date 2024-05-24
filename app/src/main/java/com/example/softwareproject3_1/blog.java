package com.example.softwareproject3_1;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.*;
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
                Log.e("MainActivity", "Error fetching data", databaseError.toException());
            }
        });
    }
}
