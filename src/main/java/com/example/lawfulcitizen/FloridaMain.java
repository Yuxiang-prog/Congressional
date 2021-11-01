package com.example.lawfulcitizen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FloridaMain extends AppCompatActivity {
    //intializes all the navigation button
    //https://stackoverflow.com/questions/5026349/how-to-open-a-website-when-a-button-is-clicked-in-android-application
    //https://stackoverflow.com/questions/28452042/can-i-pass-a-parameter-from-a-layout-xml-to-a-method-in-the-mainactivity
    private Button floridabutton;
    private Button wipbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_statelaw);

        floridabutton = (Button) findViewById(R.id.floridabutton);
        wipbutton = (Button) findViewById(R.id.wipbutton);

        navigate(floridabutton, FloridaPageActivity.class);
        navigate(wipbutton, null);
        //CRITICAL! in the manifest, set your home page as the parent action of this class
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
                        Intent intent1 = new Intent(FloridaMain.this, MapMain.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(FloridaMain.this, HomeFederal.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        //Intent intent3 = new Intent(FloridaMain.this, FloridaMain.class);
                        //startActivity(intent3);

                        break;


                }


                return false;
            }
        });
    }

    public void navigate(Button button, Class c) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.equals(floridabutton)) {
                    Intent i = new Intent(FloridaMain.this, c);
                    startActivity(i);
                } else if (button.equals(wipbutton)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FloridaMain.this);

                    builder.setCancelable(true);
                    builder.setTitle("Feature not avaiable yet");
                    builder.setMessage("As of now, only our homestate, Florida, has a state law page. We hope to implement more states in the future.");

                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();


                }
            }
        });
    }


}
