package com.example.softwareproject3_1;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.softwareproject3_1.R;
import java.util.List;

public class BlogPostAdapter extends RecyclerView.Adapter<BlogPostAdapter.BlogPostViewHolder> {
    private List<BlogPost> blogPosts;

    public BlogPostAdapter(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    @NonNull
    @Override
    public BlogPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new BlogPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogPostViewHolder holder, int position) {
        BlogPost blogPost = blogPosts.get(position);
        holder.titleTextView.setText(blogPost.getTitle());
        holder.contentTextView.setText(blogPost.getContent());
        holder.subjectTextView.setText(blogPost.getSubject()); // Set subject

        holder.contentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle between showing full content and truncated content
                if (holder.contentTextView.getMaxLines() == 10) {
                    // If already expanded, collapse the TextView
                    holder.contentTextView.setMaxLines(3); // Set the original maxLines value
                    holder.contentTextView.setEllipsize(TextUtils.TruncateAt.END); // Add ellipsis
                } else {
                    // If truncated, expand the TextView to show full content
                    holder.contentTextView.setMaxLines(10); // Set a large value
                    holder.contentTextView.setEllipsize(null); // Remove ellipsis
                }
            }
        });









    }

    @Override
    public int getItemCount() {
        return blogPosts.size();
    }

    static class BlogPostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentTextView;
        TextView subjectTextView; // New TextView for subject

        BlogPostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
        }
    }
}