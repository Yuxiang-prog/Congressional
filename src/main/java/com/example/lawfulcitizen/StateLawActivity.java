package com.example.lawfulcitizen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.net.Uri;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StateLawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myIntent = getIntent();
        String nav = myIntent.getStringExtra("nav");

        if(nav.equals("abortion"))
            setContentView(R.layout.abortion_page);
        else if(nav.equals("parent"))
            setContentView(R.layout.parenting_page);
        else if(nav.equals("parent"))
            setContentView(R.layout.parenting_page);
        else if(nav.equals("parent"))
            setContentView(R.layout.parenting_page);

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
                        Intent intent1 = new Intent(StateLawActivity.this, MapMain.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(StateLawActivity.this, HomeFederal.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(StateLawActivity.this, FloridaMain.class);
                        startActivity(intent3);
                        break;


                }


                return false;
            }
        });
    }

    public void gotoWeb(View view) {

        switch (view.getId()) {
            case R.id.abortionlink:
                goToUrl("https://www.plannedparenthood.org/planned-parenthood-south-east-north-florida/for-patients/teens-seeking-abortion-services#:~:text=Florida%20state%20law%20requires%20that,you%20to%20have%20an%20abortion.");
                break;
            case R.id.abortionlink2:
                Intent call = new Intent();
                call.setData(Uri.parse("tel:8007729100"));
                startActivity(call);
                break;
            case R.id.abortionlink3:
                goToUrl("http://www.leg.state.fl.us/statutes/index.cfm?App_mode=Display_Statute&URL=0300-0399/0390/0390.html");
                break;


            case R.id.parentinglink:
                goToUrl("http://laws.flrules.org/2021/199");
                break;



        }
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
