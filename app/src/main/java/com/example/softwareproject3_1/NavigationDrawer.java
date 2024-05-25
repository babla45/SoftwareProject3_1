package com.example.softwareproject3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton imageButton;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawerLayout=findViewById(R.id.main);
        imageButton=findViewById(R.id.menuButtonId);
        navigationView=findViewById(R.id.navigationViewId);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int menuId=menuItem.getItemId();
                if(menuId==R.id.homeMenuId)
                {
                    Toast.makeText(NavigationDrawer.this, "Home menu clicked", Toast.LENGTH_SHORT).show();
                }
                else if(menuId==R.id.contactMenuId)
                {
                    Toast.makeText(NavigationDrawer.this, "Contact menu clicked", Toast.LENGTH_SHORT).show();
                }
                else if(menuId==R.id.settingMenuId)
                {
                    Toast.makeText(NavigationDrawer.this, "Setting menu clicked", Toast.LENGTH_SHORT).show();
                }
                else if(menuId==R.id.shareMenuId)
                {
                    Toast.makeText(NavigationDrawer.this, "Share menu clicked", Toast.LENGTH_SHORT).show();
                }
                else if(menuId==R.id.logOutMenuId)
                {
                    startActivity(new Intent(NavigationDrawer.this, login_Activity.class));
                    Toast.makeText(NavigationDrawer.this, "Bye! See You Later", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(NavigationDrawer.this, "NO menu clicked", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.close();
                return false;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseAuth.getInstance().signOut();
    }

    public void website(View view) {
        Intent intent=new Intent(NavigationDrawer.this, websiteManager.class);
        if(view.getId()==R.id.youtubeButtonId)
        {
            intent.putExtra("youtube","https://www.youtube.com");
        }
        if(view.getId()==R.id.googleButtonId)
        {
            intent.putExtra("youtube","https://www.google.com");
        }
        if(view.getId()==R.id.portfolioButtonId)
        {
            intent.putExtra("youtube","https://babla45.github.io/myPortfolio");
        }
        startActivity(intent);
    }
}