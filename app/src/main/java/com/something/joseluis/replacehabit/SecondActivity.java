package com.something.joseluis.replacehabit;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        int colorFrom = getResources().getColor(R.color.red);
        ConstraintLayout constraintLayout = findViewById(R.id.constraint);
        constraintLayout.setBackgroundColor(colorFrom);
    }

}
