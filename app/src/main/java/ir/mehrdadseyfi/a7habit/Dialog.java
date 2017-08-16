package ir.mehrdadseyfi.a7habit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class Dialog extends AppCompatActivity {
        EditText goalName;
        Spinner  spinCat;
        EditText goalDate;
      GoalDB longDB;
    String date;
    PersianCalendar persianDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        persianDatePicker =new PersianCalendar();
        goalName = (EditText) findViewById(R.id.dialog_goalName);
//        goalDate=(EditText)findViewById(R.id.goalDate);
        spinCat = (Spinner) findViewById(R.id.spinGoal);
        longDB = new GoalDB(this, "longdb", null, 1);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goalname = goalName.getText().toString();
                String goaldate = date;
                String spincat = spinCat.getSelectedItem().toString();
                longDB.inserToDB(goalname, goaldate, spincat);
                goalName.setText("");



            }
        });
        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(1370, 3, 13);









    }



}
