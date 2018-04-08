package tabian.com.MunchHunt2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import tabian.com.actionbar.R;

/**
 * Created by User on 4/15/2017.
 */

public class SettingsPage extends AppCompatActivity {
    TextView textView;
    EditText editText;
    private static final String FILE_NAME = "example.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page_activity);


        textView = (TextView) findViewById(R.id.set);




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_food:
                        Intent intent0 = new Intent(SettingsPage.this, FeedPage.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_map:
                        Intent intent1 = new Intent(SettingsPage.this, bodyMap.class);
                        startActivity(intent1);

                        break;

                    case R.id.ic_settings:

                        break;

                }


                return false;
            }
        });
    }

    public void Load(View v) {
        if (isExternalStorageWritable() || checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            String text =
                    "Ibuprofen\tNausea\t0.3925\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tApnea\t0.28\t1\t0\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tEisonophilia\t0.233\t0\t0\t1\t1\t1\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tConstipation\t0.22\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tSomnilence\t0.22\t0\t1\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tRespiratory Tract Infections\t0.19\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tVomiting\t0.1875\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tBronchopulmonary Dysplasia\t0.155\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHyponatraemia\t0.155\t0\t0\t0\t1\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tPulmonary Hemorrhage\t0.155\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tIntraventricular Hemorrhage\t0.22\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tBacteraemia\t0.133\t0\t0\t1\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypocalcaemia\t0.12\t0\t1\t1\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypoglycemia\t0.12\t0\t1\t0\t1\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tFlatulence\t0.1178\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHeadache\t0.1798\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tPneumonia\t0.1\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tDiarrhea\t0.1\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypoproteinemia\t0.1\t0\t0\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tLactic Dehydrogenase Activity Increase\t0.1\t0\t1\t1\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypoalbuminemia\t0.1\t0\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tThrombocytosis\t0.1\t0\t1\t1\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tRespiratory Failure\t0.1\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tBlood Creatinine Increase\t0.065\t0\t0\t1\t1\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tUrinary Tract Infections\t0.09\t0\t0\t0\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tAdrenal Insufficiency\t0.07\t0\t0\t1\t0\t0\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypernatraemia\t0.06835\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHemorrhage\t0.0699\t1\t1\t1\t1\t1\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tRenal Impairment\t0.06\t0\t0\t0\t1\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tDizziness\t0.0914\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tDyspepsia\t0.0666\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tUrinary Retention\t0.04255\t0\t0\t0\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tAtelectasis\t0.04\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tOedema\t0.04\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tAnaemia\t0.095\t0\t1\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHypokalaemia\t0.071435\t0\t0\t1\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tUrine Output\t0.03\t0\t0\t0\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tHemoglobin Decreased\t0.0248\t0\t1\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tWound Hemorrhage\t0.02155\t0\t0\t1\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tOedema Peripheral\t0.01853\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tCough\t0.01824\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tAbdominal Discomfort\t0.01824\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tRenal Failure\t0.01\t0\t0\t0\t1\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Ibuprofen\tBlood Urea Increased\t0.035\t0\t0\t1\t1\t0\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tNervous system disorder\t0.097\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tInjection site reaction\t0.08685\t0\t0\t0\t1\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tMental disorder\t0.0746\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tInsomnia\t0.0746\t0\t1\t1\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tConstipation\t0.067\t0\t1\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tHeadache\t0.055\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDrowsiness\t0.01\t0\t1\t1\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDry mouth\t0.01\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDisturbance in attention\t0.01\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tUnsteadiness\t0.01\t0\t1\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tVomiting\t0.0463\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tAnaemia\t0.027\t0\t1\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDizziness\t0.027\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tCough\t0.02\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tPostoperative hemorrhage\t0.02\t0\t1\t1\t1\t1\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tEnlargement abdomen\t0.02\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tFatigue\t0.0159\t0\t1\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDiarrhoea\t0.013\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tDyspepsia\t0.013\t0\t0\t1\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tHyperglycaemia\t0.013\t1\t1\t1\t1\t0\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tHypokalaemia\t0.013\t0\t1\t1\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tAlveolitis\t0.013\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tNausea\t0.05525\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Acetaminophen\tGastrointestinal disorder\t0.02\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\t\t\t0\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tDiarrhoea\t0.0483\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tHeadache\t0.0399\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tVulvovaginal mycotic infection\t0.023\t0\t0\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tNausea\t0.0099\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tVomiting\t0.0115\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Amoxicillin\tAbdominal pain\t0.0066\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tInfection\t0.0655\t1\t1\t1\t1\t1\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tNasopharyngitis\t0.083\t0\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tDiarrhoea\t0.034\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tHeadache\t0.096\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tUrinary tract infection\t0.057\t0\t0\t0\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tDyspepsia\t0.03\t0\t0\t1\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tInsomnia\t0.03\t0\t1\t1\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tAbdominal pain\t0.019\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tInfluenza\t0.016\t0\t0\t0\t0\t1\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tFlatulence\t0.0195\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tConstipation\t0.0125\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tAsthenia\t0.019\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tHypersensitivity\t0.014\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tMyalgia\t0.028\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tNausea\t0.022\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Atorvastatin\tAlanine aminotransferase increased\t\t1\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tRhinitis\t0.16\t0\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tNausea\t0.194\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tInsomnia\t0.17\t0\t1\t1\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tFatigue\t0.24\t0\t1\t1\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tHeadache\t0.228\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tAsthenia\t0.131\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tSomnolence\t0.111\t0\t1\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tDizziness\t0.077\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tDry mouth\t0.081\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tDepression\t0.091\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tDiarrhoea\t0.101\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tNervousness\t0.08\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tUpper respiratory tract infection\t0.076\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tDyspepsia\t0.085\t0\t0\t1\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tInfluenza\t0.075\t0\t0\t0\t0\t1\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tInfection\t0.035\t1\t1\t1\t1\t1\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tAbdominal pain\t0.073\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tAnxiety\t0.087\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tUrinary tract infection\t0.051\t0\t0\t0\t1\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tConstipation\t0.056\t0\t0\t0\t0\t0\t1\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tGastrointestinal disorder\t0.057\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tHaemorrhage\t0.025\t1\t1\t1\t1\t1\t1\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tHypersensitivity\t0.025\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tPalpitations\t0.03\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tPruritus\t0.03\t0\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tSinusitis\t0.035\t0\t0\t0\t0\t1\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tMood swings\t0.027\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tMuscle twitching\t0.02\t0\t0\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tThinking abnormal\t0.04\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tSleep disorder\t0.02\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tLibido decreased\t0.06\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tMyalgia\t0.04\t0\t1\t0\t0\t0\t0\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tFlatulence\t0.051\t0\t0\t0\t0\t0\t0\t1\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "Paroxetine\tVomiting\t0.03\t0\t0\t0\t0\t0\t0\t1";
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());

                editText.getText().clear();
                Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                        Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Toast.makeText(this, "Cannot Write to External Storage.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkPermission(String permission) {

        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    private boolean isExternalStorageWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Log.i("State", "Yes, it is writable!");
            return true;
        } else {
            return false;
        }
    }


    public void Check(View v) {
        if (isExternalStorageReadable()) {
            FileInputStream fis = null;

            try {
                fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text;

                while ((text = br.readLine()) != null) {
                    sb.append(text).append("\n");
                }

                textView.setText(sb.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Toast.makeText(this, "Cannot Read from External Storage.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isExternalStorageReadable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())|| checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Log.i("State", "Yes, it is readable!");
            return true;
        } else {
            return false;
        }
    }
}


