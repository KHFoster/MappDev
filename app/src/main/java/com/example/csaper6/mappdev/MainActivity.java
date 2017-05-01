package com.example.csaper6.mappdev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton currentOption, fab1, fab2, fab3;
    private boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicked = false;




        currentOption = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);

        currentOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
                Animation hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);


                if (clicked == false) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
                    layoutParams.rightMargin += (int) (fab1.getWidth() * 1.7);
                    layoutParams.bottomMargin += (int) (fab1.getHeight() * 0.25);
                    fab1.setLayoutParams(layoutParams);
                    fab1.startAnimation(show_fab_1);
                    fab1.setClickable(true);
                    clicked = true;
                }
                else {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
                    layoutParams.rightMargin -= (int) (fab1.getWidth() * 1.7);
                    layoutParams.bottomMargin -= (int) (fab1.getHeight() * 0.25);
                    fab1.setLayoutParams(layoutParams);
                    fab1.startAnimation(hide_fab_1);
                    fab1.setClickable(false);
                    clicked = false;
                }

            }
        });



    }
}
