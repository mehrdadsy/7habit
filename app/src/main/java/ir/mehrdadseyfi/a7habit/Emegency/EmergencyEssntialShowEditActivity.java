package ir.mehrdadseyfi.a7habit.Emegency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import ir.mehrdadseyfi.a7habit.R;

public class EmergencyEssntialShowEditActivity extends AppCompatActivity {
Long id;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial_show_edit);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 1L);
         progressBar=(ProgressBar)findViewById(R.id.graph);





    }
}
