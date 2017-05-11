package com.example.csaper6.mappdev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import static com.example.csaper6.mappdev.R.id.fab;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton currentOption, fab1, fab2, fab3;

    private boolean clicked, fab1Selected, fab2Selected, fab3Selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clicked = false;
        fab1Selected = false;
        fab2Selected = false;
        fab3Selected = false;
        wireFabs();


        currentOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked == false) {
                    openFabs(); //expand direction type selection menu
                }
                else {
                    closeFabs();
                }
            }


        });


    }
    private void wireFabs() {
        currentOption = (FloatingActionButton) findViewById(fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab1.setImageResource(R.drawable.walking_ind);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
        fab2.setImageResource(R.drawable.driving_ind);
        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);
        fab3.setImageResource(R.drawable.transport_ind);
    }
    private void openFabs() {
        Animation show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        Animation show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        Animation show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);


        FrameLayout.LayoutParams layoutParamsFab1 = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParamsFab1.rightMargin += (int) (fab1.getWidth() * 1.45);
        layoutParamsFab1.bottomMargin += (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParamsFab1);
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);

        FrameLayout.LayoutParams layoutParamsFab2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParamsFab2.rightMargin += (int) (fab2.getWidth() * 1.0);
        layoutParamsFab2.topMargin += (int) (fab2.getHeight() * 1.1 );
        fab2.setLayoutParams(layoutParamsFab2);
        fab2.startAnimation(show_fab_2);
        fab2.setClickable(true);

        FrameLayout.LayoutParams layoutParamsFab3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParamsFab3.rightMargin -= (int) (fab3.getWidth() * .17);
        layoutParamsFab3.topMargin += (int) (fab3.getHeight() * 1.4);
        fab3.setLayoutParams(layoutParamsFab3);
        fab3.startAnimation(show_fab_3);
        fab3.setClickable(true);

        clicked = true;


        fab1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!fab1Selected){
                            fab1Selected = true;
                            fab2Selected = false;
                            fab3Selected = false;
                            fab1.setImageResource(R.drawable.nav_ind);
                            fab2.setImageResource(R.drawable.driving_ind);
                            fab3.setImageResource(R.drawable.transport_ind);
                            currentOption.setImageResource(R.drawable.walking_ind);
                        }
                        else{
                            fab1Selected = false;
                            fab1.setImageResource(R.drawable.walking_ind);
                            currentOption.setImageResource(R.drawable.nav_ind);
                        }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fab2Selected) {
                    fab1Selected = false;
                    fab2Selected = true;
                    fab3Selected = false;
                    fab1.setImageResource(R.drawable.walking_ind);
                    fab2.setImageResource(R.drawable.nav_ind);
                    fab3.setImageResource(R.drawable.transport_ind);
                    currentOption.setImageResource(R.drawable.driving_ind);
                } else {
                    fab2Selected = false;
                    fab2.setImageResource(R.drawable.driving_ind);
                    currentOption.setImageResource(R.drawable.nav_ind);
                }
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fab3Selected){
                    fab1Selected = false;
                    fab2Selected = false;
                    fab3Selected = true;
                    fab1.setImageResource(R.drawable.walking_ind);
                    fab2.setImageResource(R.drawable.driving_ind);
                    fab3.setImageResource(R.drawable.nav_ind);
                    currentOption.setImageResource(R.drawable.transport_ind);
                }
                else{
                    fab3Selected = false;
                    fab3.setImageResource(R.drawable.transport_ind );
                    currentOption.setImageResource(R.drawable.nav_ind);
                }
            }
        });
    }
    private void closeFabs() {
        Animation hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        Animation hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
        Animation hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);

        FrameLayout.LayoutParams layoutParamsFab1 = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParamsFab1.rightMargin -= (int) (fab1.getWidth() * 1.45);
        layoutParamsFab1.bottomMargin -= (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParamsFab1);
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);

        FrameLayout.LayoutParams layoutParamsFab2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParamsFab2.rightMargin -= (int) (fab2.getWidth() * 1.0);
        layoutParamsFab2.topMargin -= (int) (fab2.getHeight() * 1.1);
        fab2.setLayoutParams(layoutParamsFab2);
        fab2.startAnimation(hide_fab_2);
        fab2.setClickable(false);

        FrameLayout.LayoutParams layoutParamsFab3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParamsFab3.rightMargin += (int) (fab3.getWidth() * .17);
        layoutParamsFab3.topMargin -= (int) (fab3.getHeight() * 1.4);
        fab3.setLayoutParams(layoutParamsFab3);
        fab3.startAnimation(hide_fab_3);
        fab3.setClickable(false);

        clicked = false;
    }
}
