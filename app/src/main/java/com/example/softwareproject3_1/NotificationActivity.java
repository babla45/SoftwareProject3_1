package com.example.softwareproject3_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity implements child {
    TextView notificationTitle;
    TextView notificationMessage;
    private parent observable;
    private Button dismissButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Log.d("ObserverRegistration", "Registering observer in NotificationActivity");

        notificationTitle = findViewById(R.id.notificationTitleTextView);
        notificationMessage = findViewById(R.id.notificationMessageTextView);
        dismissButton = findViewById(R.id.dismissButton);

        observable = parent.getInstance(); // Use the class-level variable
        observable.addChildObserver(this);

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissNotification();
            }
        });
    }

    @Override
    public void afterchange() {
        // Get the new notification message from the parent class
        String notification = "New Blog Post";
        String notificationM = "A new blog post has been added. Check it out!";

        // Update the notification text views with the new message
        notificationTitle.setText(notification);
        notificationMessage.setText(notificationM);

        // Show a toast message for confirmation
        Toast.makeText(this, "New notification received", Toast.LENGTH_SHORT).show();
    }

    private void dismissNotification() {
        // Clear the notification text views
        notificationTitle.setText("");
        notificationMessage.setText("");
        // Optionally show a toast message for confirmation
        Toast.makeText(this, "Notification dismissed", Toast.LENGTH_SHORT).show();
    }
}
