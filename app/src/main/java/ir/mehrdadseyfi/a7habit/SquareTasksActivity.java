package ir.mehrdadseyfi.a7habit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SquareTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_tasks);
        findViewById(R.id.emrgency_esstial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
