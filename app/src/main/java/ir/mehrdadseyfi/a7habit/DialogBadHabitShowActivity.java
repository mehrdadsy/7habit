package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class DialogBadHabitShowActivity extends AppCompatActivity {
    Long id;
    BadHabitDB habit;
    EditText title;
    EditText detial;
    EditText upgrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_bad_habit_show);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 1L);
        habit = BadHabitDB.findById(BadHabitDB.class, id);
        title=(EditText)findViewById(R.id.show_title);
        detial=(EditText)findViewById(R.id.show_detial);
        upgrade=(EditText)findViewById(R.id.show_upgrade);
        title.setText(habit.getHabitTitle());
        detial.setText(habit.getHabitdetails());
        upgrade.setText(habit.getUpgradeHabit());
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=title.getText().toString();
                String d=detial.getText().toString();
                String u=upgrade.getText().toString();
                habit.setHabitTitle(t);
                habit.setHabitdetails(d);
                habit.setUpgradeHabit(u);
                habit.save();

            }
        });




    }
}
