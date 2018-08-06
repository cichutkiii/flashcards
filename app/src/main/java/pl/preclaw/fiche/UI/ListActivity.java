package pl.preclaw.fiche.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import data.ClassAdapter;
import data.ClassItem;
import data.RecyclerItemClickListener;
import data.StaticData;
import pl.preclaw.fiche.R;

public class ListActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    ClassAdapter classAdapter;
    String whereToGo;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            whereToGo = bundle.getString(StaticData.WHERE_TO_GO);
        }
        FirebaseApp.initializeApp(ListActivity.this);
        DatabaseReference mSubjectReference = FirebaseDatabase.getInstance().getReference().child("Przedmioty");
        rvList.setLayoutManager(new LinearLayoutManager(this));
        classAdapter = new ClassAdapter(this, mSubjectReference);
        rvList.setAdapter(classAdapter);
        rvList.addOnItemTouchListener(new RecyclerItemClickListener(this, rvList, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassItem clickedSubject = classAdapter.getTitles(position);
                Bundle bundle = new Bundle();
                bundle.putString(StaticData.LINK, clickedSubject.getOnDatabase());
                bundle.putString(StaticData.NAME, clickedSubject.getName());
                if(whereToGo.equals("test")){
                    intent = new Intent(ListActivity.this, TestActivity.class);
                }else if(whereToGo.equals("knowledge")){
                    intent = new Intent(ListActivity.this, KnowledgeActivity.class);

                }
                intent.putExtras(bundle);
                startActivity(intent);


            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }

}
