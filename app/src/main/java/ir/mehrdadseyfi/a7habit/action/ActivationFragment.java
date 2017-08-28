package ir.mehrdadseyfi.a7habit.action;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mehrdadseyfi.a7habit.R;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
public class ActivationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activation_fragment, container, false);
    }
}