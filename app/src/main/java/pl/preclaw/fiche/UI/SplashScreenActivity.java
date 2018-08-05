package pl.preclaw.fiche.UI;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import data.AnimationsUtils;
import pl.preclaw.fiche.R;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.title_splash)
    TextView titleSplash;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.title_splash2)
    TextView titleSplash2;
    @BindView(R.id.date3)
    ImageView date3;
    @BindView(R.id.date4)
    ImageView date4;
    @BindView(R.id.date5)
    ImageView date5;
    @BindView(R.id.date6)
    ImageView date6;
    @BindView(R.id.date7)
    ImageView date7;
    @BindView(R.id.date8)
    ImageView date8;
    @BindView(R.id.date9)
    ImageView date9;
    @BindView(R.id.date10)
    ImageView date10;
    @BindView(R.id.date11)
    ImageView date11;
    @BindView(R.id.date12)
    ImageView date12;
    @BindView(R.id.date13)
    ImageView date13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        AnimationsUtils au = new AnimationsUtils();


        Animation oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(0));
        date3.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(1));
        date4.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(2));
        date5.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(3));
        date6.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(4));
        date7.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(5));
        date8.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(6));
        date9.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(7));
        date10.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(8));
        date11.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(9));
        date12.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(10));
        date13.startAnimation(oneAnimation);
        oneAnimation = AnimationUtils.loadAnimation(getApplicationContext(),au.getAnimationsList().get(11));
        logo.startAnimation(oneAnimation);
        titleSplash.startAnimation(oneAnimation);
        titleSplash2.startAnimation(oneAnimation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        SplashScreenActivity.this.startActivity(intent);
                        SplashScreenActivity.this.finish();

                    }
                }, 2000);
            }
        }, 6000);
    }
}
