package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialActivity;
import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialItem;

public class SquareTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_tasks);

        findViewById(R.id.emrgency_esstial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               List<EmergencyEssntialItem> models = EmergencyEssntialItem.listAll(EmergencyEssntialItem.class);


                    startActivity(new Intent(SquareTasksActivity.this, EmergencyEssntialActivity.class));


            }
        });
    }
}
