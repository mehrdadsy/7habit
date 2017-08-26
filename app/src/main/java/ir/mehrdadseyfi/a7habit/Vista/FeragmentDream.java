package ir.mehrdadseyfi.a7habit.Vista;

/**
 * Created by admin on 8/26/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/26/2017.
 */

        public class FeragmentDream extends Fragment {

    private static FeragmentDream feragmentDream;



    public static FeragmentDream newInstance() {

        if (null == feragmentDream)

            feragmentDream = new FeragmentDream();

        return feragmentDream;

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dream, container, false);




        return view;

    }

}