package pl.preclaw.fiche.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import data.StaticData;
import pl.preclaw.fiche.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }
    public void goToKnowledge(View view){

        ActionActivity("knowledge");
    }
    public void goToTest(View view){
        ActionActivity("test");
    }
    public void goToAbout(View view){
        ActionActivity("about");
    }

    public void ActionActivity(String whereToGo){
        if(whereToGo.contains("about")){
            Intent intent = new Intent(this, AboutActivity.class);
            intent.putExtra(StaticData.WHERE_TO_GO,"about");
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra(StaticData.WHERE_TO_GO,whereToGo);
            startActivity(intent);
        }
    }

}
