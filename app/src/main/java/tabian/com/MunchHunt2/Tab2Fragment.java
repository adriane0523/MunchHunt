package tabian.com.MunchHunt2;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tabian.com.actionbar.R;

import static android.provider.Telephony.Mms.Part.FILENAME;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button btnTEST;
    TextView text1;
    Button refresh;
    public static final String FILENAME = "meds.txt";
    ArrayList<Object> arr1 = new ArrayList<>();
    int size = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);

        text1 = (TextView) view.findViewById(R.id.text1);
        String result = "/Hepatic/Neuro/Cardio/Renal/Pulmonry/Endo/Gastro/\n\n" +
                "Ibuprofen: 29.6%/ 29.9%/ 31.3% /25.6% /31.8% /23.4% /44.7\n\n"
                +"Acetaminophen: 0%/ 10.2%/ 7.6%/ 8.8%/ 2.7%/ 7.8%/ 5.7%/\n\n" +
                "Amoxicillin: 0%/ 0%/ 0%/ 0%/ 0%/ 0%/ 0%/ 4.9%/";
        text1.setText(result);





        return view;
    }




}