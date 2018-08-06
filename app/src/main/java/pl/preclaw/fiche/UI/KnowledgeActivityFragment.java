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
public class KnowledgeActivityFragment extends Fragment {

    public KnowledgeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_knowledge, container, false);
    }
}
