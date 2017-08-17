package ir.mehrdadseyfi.a7habit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayClickedListener;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;

public class Dialog extends AppCompatActivity {
    EditText goalName;
    Spinner spinCat;
    EditText goalDate;

    String date;
    PersianCalendarView test;
    PersianCalendarView calendarView;
    GoalSugarDB sugarLonGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        goalName = (EditText) findViewById(R.id.dialog_goalName);
        spinCat = (Spinner) findViewById(R.id.spinGoal);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goalname = goalName.getText().toString();
                String goaldate = date;
                String spincat = spinCat.getSelectedItem().toString();
                 sugarLonGoal = new GoalSugarDB(goalname, goaldate, spincat);
                sugarLonGoal.save();
                goalName.setText("");


            }
        });
        test = new PersianCalendarView(this);
        test.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate persianDate) {
                date = String.valueOf(persianDate.getYear()) + "/" + String.valueOf(persianDate.getMonth()) + "/" + String.valueOf(persianDate.getDayOfMonth());
                Toast.makeText(Dialog.this, date, Toast.LENGTH_SHORT).show();

            }
        });


    }


}
