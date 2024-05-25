package com.example.softwareproject3_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity implements child {
    TextView notificationTitle;
    TextView notificationMessage;
    public parent observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Log.d("ObserverRegistration", "Registering observer in NotificationActivity");

       notificationTitle = findViewById(R.id.notificationTitleTextView);
       notificationMessage=findViewById(R.id.notificationMessageTextView);
        observable = parent.getInstance(); // Use the class-level variable
        observable.addChildObserver(this);



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

    }

}