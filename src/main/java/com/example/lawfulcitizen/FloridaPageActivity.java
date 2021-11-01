package com.example.lawfulcitizen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FloridaPageActivity extends AppCompatActivity {

    private Button abortionbutton;
    private Button parentbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.florida_page);

        abortionbutton = (Button) findViewById(R.id.abortionbutton);
        parentbutton = (Button) findViewById(R.id.parentingbutton);

        navigate(abortionbutton,"abortion");
        navigate(parentbutton,"parent");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        // BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_android:

                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(FloridaPageActivity.this, HomeFederal.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(FloridaPageActivity.this, FloridaMain.class);
                        startActivity(intent3);

                        break;


                }


                return false;
            }
        });
    }

    public void navigate(Button button,String nav){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FloridaPageActivity.this, StateLawActivity.class);
                i.putExtra("nav",nav);
                startActivity(i);
            }
        });
    }




}
