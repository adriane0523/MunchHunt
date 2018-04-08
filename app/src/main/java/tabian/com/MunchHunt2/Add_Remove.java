package tabian.com.MunchHunt2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import tabian.com.actionbar.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Add_Remove extends AppCompatActivity {
    String addString;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addString = "";


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__remove);



        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Country);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);

        Button add = (Button)findViewById(R.id.add2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = getIntent().getExtras();
                if (extra != null)
                    addString = "\n" + extra.getString("getName") + "\n" + autoCompleteTextView.getText().toString() + "\n";
                else
                    addString = autoCompleteTextView.getText().toString();
                autoCompleteTextView.setText("");
                count++;



                Intent intent = new Intent(Add_Remove.this, bodyMap.class);
                intent.putExtra("name", addString);

                startActivity(intent);


            }
        });


    }



    private static String[] Country = new String[]{"ibuprofen", "acetaminophen", "amoxicillin", "atorvastatin", "paroxetine"};




    public String getString()
    {
        return addString;
    }
    public int getCount()
    {
        return count;
    }




}



