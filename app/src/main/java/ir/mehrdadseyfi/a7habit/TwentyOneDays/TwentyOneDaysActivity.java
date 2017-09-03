package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import ir.mehrdadseyfi.a7habit.MainActivity;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.Vista.VistaActivity;

import static ir.mehrdadseyfi.a7habit.R.anim.shake;

public class TwentyOneDaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one_days);
        ImageView img=(ImageView)findViewById(R.id.point);
        Animation animationHelp = AnimationUtils.loadAnimation(TwentyOneDaysActivity.this, R.anim.shake);
        img.startAnimation(animationHelp);
        ImageView img1=(ImageView)findViewById(R.id.add_21);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwentyOneDaysActivity.this, MainStart21DayActivity.class));
            }
        });


    }
}
