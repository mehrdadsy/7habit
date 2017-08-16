package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GoalActivity extends AppCompatActivity {
    ImageView long_goal;
    ImageView short_goal;
    GoalDB databaseGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_goal);
        long_goal=(ImageView)findViewById(R.id.long_goal);
        short_goal=(ImageView)findViewById(R.id.short_goal);
        long_goal.setImageResource(R.drawable.hadaf_boland);
       short_goal.setImageResource(R.drawable.hadaf_kootah);
            long_goal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GoalActivity.this, LongGoalActivity.class));

                }
            });
        short_goal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              startActivity(new Intent(GoalActivity.this, ShotGoalActivity.class));

                }
            });



    }
}
