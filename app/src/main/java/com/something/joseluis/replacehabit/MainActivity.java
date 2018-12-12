package com.something.joseluis.replacehabit;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int blueColor = getResources().getColor(R.color.blue);
        final int lightBlueColor = getResources().getColor(R.color.lightBlue);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animateBackground(blueColor,lightBlueColor);
        animateText();


    }

    private void animateBackground(int blueColor,int lightBlueColor){
        ConstraintLayout constraintLayout=findViewById(R.id.constraint);

        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), blueColor, lightBlueColor);
        colorAnimation.setDuration(6000); // milliseconds
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                ConstraintLayout constraintLayout = findViewById(R.id.constraint);
                constraintLayout.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        constraintLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), SecondActivity.class);

                startActivity(nextScreen);

            }
        });
        colorAnimation.start();
    }

    private void animateText(){
        final TextView textView = findViewById(R.id.firstText);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                textView.setAlpha(alpha);
            }
        });
        valueAnimator.start();
    }

}
