package ir.mehrdadseyfi.a7habit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogBadHabitAddActivity extends AppCompatActivity {
    EditText tilteHabit;
    EditText detialHabit;
    EditText upgradeHabit;
    BadHabitDB badHabitDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog_bad_habit_add);
        tilteHabit=(EditText)findViewById(R.id.tilteHabit);
        detialHabit=(EditText)findViewById(R.id.detialHabit);
        upgradeHabit=(EditText)findViewById(R.id.upgradeHabit);
        findViewById(R.id.saveHabit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleDB=tilteHabit.getText().toString();
                String  detialDB=detialHabit.getText().toString();
                String upgardeDB=upgradeHabit.getText().toString();
                badHabitDB=new BadHabitDB(titleDB,detialDB,upgardeDB);
                badHabitDB.save();
                tilteHabit.setText("");
                detialHabit.setText("");
                upgradeHabit.setText("");
                Toast.makeText(DialogBadHabitAddActivity.this, "عادت بد ذخیره شد", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
