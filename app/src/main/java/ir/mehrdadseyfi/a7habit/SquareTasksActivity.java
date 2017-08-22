package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialActivity;

public class SquareTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_tasks);
        findViewById(R.id.emrgency_esstial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SquareTasksActivity.this, EmergencyEssntialActivity.class));
                ImageView img_ee=(ImageView)findViewById(R.id.icon_ee);
                ImageView img_eu=(ImageView)findViewById(R.id.icon_eu);
                ImageView img_ue=(ImageView)findViewById(R.id.icon_ue);
                ImageView img_uu=(ImageView)findViewById(R.id.icon_uu);
//                img_ee.setImageResource(R.drawable.ic_alarm_black_48dp);
//                img_eu.setImageResource(R.drawable.ic_alarm_black_48dp);
//                img_ue.setImageResource(R.drawable.ic_alarm_black_48dp);
//                img_uu.setImageResource(R.drawable.ic_alarm_black_48dp);

            }
        });
    }
}
