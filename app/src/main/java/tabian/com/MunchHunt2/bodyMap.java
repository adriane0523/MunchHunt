package tabian.com.MunchHunt2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import tabian.com.actionbar.R;

public class bodyMap extends AppCompatActivity {
    Add_Remove add1 = new Add_Remove();
    int count = 0;
    TextView view;
    ArrayList<String> meds = new ArrayList<>();
    Tab2Fragment tab = new Tab2Fragment();
    String result = "";

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Read values from the "savedInstanceState"-object and put them in your textview
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the values you need from your textview into "outState"-object
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_map);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        Button add = (Button) findViewById(R.id.add1);
        Button finish = (Button) findViewById(R.id.finish);
        view = (TextView) findViewById(R.id.view12);
        Intent in = getIntent();

        Bundle b = in.getExtras();
        if (b!= null) {

           view.append("\n" + b.get("name") + "\n");

        }






       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(bodyMap.this, Add_Remove.class);
               intent.putExtra("getName", view.getText().toString());

               startActivity(intent);

           }
       });

       finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               /*
               String str = view.getText().toString();


               for (int i = 0; i < view.getText().toString().length();i++)
               {
                   String charVar = str.charAt(i) + " ";
                   if (charVar.equals(" ") )
                   {

                       meds.add(result);
                       result = "";


                   }
                   else
                   {
                       result += str.charAt(i);
                   }
               }
               */

               Intent in1 = new Intent(bodyMap.this, FeedPage.class);
              // in1.putExtra("name1", meds);
               startActivity(in1);



           }
       });



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_food:
                        Intent intent0 = new Intent(bodyMap.this, FeedPage.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_map:
                        // Intent intent1 = new Intent(SettingsPage.this, MapPage.class);
                        //startActivity(intent1);
                        break;

                    case R.id.ic_settings:
                        Intent intent2 = new Intent(bodyMap.this, SettingsPage.class);
                        startActivity(intent2);

                        break;

                }


                return false;
            }
        });
    }












}

