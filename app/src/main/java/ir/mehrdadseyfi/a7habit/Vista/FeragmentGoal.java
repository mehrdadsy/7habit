package ir.mehrdadseyfi.a7habit.Vista;

/**
 * Created by admin on 8/26/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/26/2017.
 */

        public class FeragmentGoal extends Fragment {

    private static FeragmentGoal feragmentGoal;



    public static FeragmentGoal newInstance() {

        if (null == feragmentGoal)

            feragmentGoal = new FeragmentGoal();

        return feragmentGoal;

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_goal, container, false);

        TextView myText = (TextView) view.findViewById(R.id.mytext);

       myText.setText("testttt");

        return view;

    }

}