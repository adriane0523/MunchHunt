package tabian.com.MunchHunt2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import tabian.com.actionbar.R;


public class Tab1Fragment extends Fragment {
    TextView brain, lungs, liver, heart, stomach, pancreas, kidney;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);

         brain = (TextView) view.findViewById(R.id.brain);
        lungs = (TextView) view.findViewById(R.id.lungs);
        heart = (TextView) view.findViewById(R.id.heart);
        stomach = (TextView) view.findViewById(R.id.stomach);
        liver = (TextView) view.findViewById(R.id.liver);
        pancreas = (TextView) view.findViewById(R.id.pancreas);
        kidney = (TextView) view.findViewById(R.id.kidney);




        return view;
}


}