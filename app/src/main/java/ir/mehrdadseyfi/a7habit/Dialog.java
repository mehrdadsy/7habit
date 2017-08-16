package ir.mehrdadseyfi.a7habit;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Dialog extends AppCompatActivity {
        EditText goalName;
        Spinner  spinCat;
        EditText goalDate;
      GoalDB longDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        goalName=(EditText)findViewById(R.id.dialog_goalName);
        goalDate=(EditText)findViewById(R.id.goalDate);
        spinCat=(Spinner)findViewById(R.id.spinGoal);
        longDB=new GoalDB(this,"longdb",null,1);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goalname=goalName.getText().toString();
                String goaldate=goalDate.getText().toString();
                String spincat=spinCat.getSelectedItem().toString();
                longDB.inserToDB(goalname,goaldate,spincat);
                goalName.setText("");
                goalDate.setText("");
            }
        });

    }

}
