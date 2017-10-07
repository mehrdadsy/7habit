package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.ShowTipActivity;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TwentyOneDaysActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class days1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days1);
        
        findViewById(R.id.go_tr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(days1.this, Day1_tr.class);
                startActivity(intent);
                finish();
            }
        });
    }

}

