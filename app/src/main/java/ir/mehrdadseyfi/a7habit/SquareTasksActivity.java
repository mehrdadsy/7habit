package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialActivity;
import ir.mehrdadseyfi.a7habit.Esstinal.Noemergency.NoEmergencyEssntialActivity;
import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEmergencyNoEsstialActivity;
import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.NOEsstianlEmergencyActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SquareTasksActivity extends AppCompatActivity {
Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_tasks);


        findViewById(R.id.emrgency_esstial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    startActivity(new Intent(SquareTasksActivity.this, EmergencyEssntialActivity.class));


            }
        });
        findViewById(R.id.emrgency_nesstial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    startActivity(new Intent(SquareTasksActivity.this, NoEmergencyEssntialActivity.class));


            }
        });findViewById(R.id.nemrgency_nesstial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    startActivity(new Intent(SquareTasksActivity.this, NOEmergencyNoEsstialActivity.class));


            }
        });findViewById(R.id.nemrgency_esstial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    startActivity(new Intent(SquareTasksActivity.this, NOEsstianlEmergencyActivity.class));


            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
