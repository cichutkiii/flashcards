package pl.preclaw.fiche.UI;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.preclaw.fiche.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestActivityFragment extends Fragment {
    String classLink;
    String classtitle;

    public TestActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        classLink = getArguments().getString("LINK");
        classtitle = getArguments().getString("NAME");
        final View rootView = inflater.inflate(R.layout.fragment_test, container, false);


















        return rootView;
    }
}
