package ir.mehrdadseyfi.a7habit.Calender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import ir.mehrdadseyfi.a7habit.R;

public class AddJobActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    ImageView startDate;
    ImageView endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
       startDate=(ImageView)findViewById(R.id.start_date);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersianCalendar persianCalendar = new PersianCalendar();
                DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                        AddJobActivity.this,
                        persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay()
                );
                datePickerDialog.show(getFragmentManager(), "Datepickerdialog");
                PersianCalendar persianCalendar1 = new PersianCalendar();
                TimePickerDialog timer = TimePickerDialog.newInstance(
                        AddJobActivity.this,
                        12, 59, true
                );
                timer.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        endDate=(ImageView)findViewById(R.id.end_hours);
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timer1 = TimePickerDialog.newInstance(
                        AddJobActivity.this,
                        12, 59, true
                );
                timer1.show(getFragmentManager(), "Datepickerdialog");
            }
        });


    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }
}
