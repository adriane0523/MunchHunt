package tabian.com.MunchHunt2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import tabian.com.actionbar.R;

/**
 * Created by User on 4/15/2017.
 */

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page_activity);

        TextView title = (TextView) findViewById(R.id.activityTitle2);
        title.setText("This is SettingsPage");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_food:
                        Intent intent0 = new Intent(SettingsPage.this, FeedPage.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_map:
                        Intent intent1 = new Intent(SettingsPage.this, MapPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_settings:

                        break;

                }


                return false;
            }
        });
    }

}
