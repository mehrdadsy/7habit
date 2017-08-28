package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class VistaActivity extends AppCompatActivity {
    LinearLayout mainLayout;
    TabLayout tabLayout;
    Toolbar tool;
    ImageView add;
    ImageView help;
    Animation animation;
    Animation animationHelp;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);

        fragment = new FeragmentDream();
        add = (ImageView) findViewById(R.id.add);
        help = (ImageView) findViewById(R.id.help);
        animation = AnimationUtils.loadAnimation(VistaActivity.this, R.anim.rotate_clockwise);
        animationHelp = AnimationUtils.loadAnimation(VistaActivity.this, R.anim.blink);
        add.startAnimation(animation);
        help.startAnimation(animationHelp);
        fmShow();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VistaActivity.this, AddDialogActivity.class));
            }
        });

        tool = (Toolbar) findViewById(R.id.tool);
        mainLayout = (LinearLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
        tabLayout.setTabGravity(0);
// Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("رویا"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.dream);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.dream));
        // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("نقش"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.role); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("هدف"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.goal); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
// get the current selected tab's position and replace the fragment accordingly
                 fragment = new FeragmentDream();
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.dream));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.role));
                        add.startAnimation(animation);
                        help.startAnimation(animationHelp);
                        tool.setBackgroundColor(getResources().getColor(R.color.dream));
                        fragment = new FeragmentDream();
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.role));
                        tool.setBackgroundColor(getResources().getColor(R.color.role));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.goal));
                        add.startAnimation(animation);
                        help.startAnimation(animationHelp);
                        fragment = new FeragmentRole();
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.goal));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.dream));
                        tool.setBackgroundColor(getResources().getColor(R.color.goal));
                        add.startAnimation(animation);
                        help.startAnimation(animationHelp);
                        fragment = new FeragmentGoal();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }


        });
    }
    public void fmShow() {
        fragment = new FeragmentDream();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}


