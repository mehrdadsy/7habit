package ir.mehrdadseyfi.a7habit.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by Mehrdad on 9/10/2017.
 */

public class FragmentC extends Fragment {

    private static FragmentC fragmentA;



    public static FragmentC newInstance() {

        if (null == fragmentA)

            fragmentA = new FragmentC();

        return fragmentA;

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_c, container, false);


//        myText.setText("testttt");

        return view;

    }

}