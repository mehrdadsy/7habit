package ir.mehrdadseyfi.a7habit.Emegency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import ir.mehrdadseyfi.a7habit.R;

public class EmergencyEssntialDialogActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    EditText tilteEE;
    EditText detialEE;
    EditText calenderEE;
    EmergencyEssntialItem EEItem;
    int hours;
    int min;
    int years;
    int mounth;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial_dialog);

        tilteEE = (EditText) findViewById(R.id.add_title_EE);
        detialEE = (EditText) findViewById(R.id.add_detial_EE);
        ImageView imgBtn=(ImageView) findViewById(R.id.calender);
        imgBtn.setImageResource(R.drawable.ic_alarm_black_48dp);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersianCalendar persianCalendar = new PersianCalendar();
                DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                        EmergencyEssntialDialogActivity.this,
                        persianCalendar.getPersianYear(),
                        persianCalendar.getPersianMonth(),
                        persianCalendar.getPersianDay()
                );
                datePickerDialog.show(getFragmentManager(), "Datepickerdialog");
                PersianCalendar persianCalendar1 = new PersianCalendar();
                TimePickerDialog timer = TimePickerDialog.newInstance(
                        EmergencyEssntialDialogActivity.this,
                        12, 59, true
                );
                timer.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = tilteEE.getText().toString();
                String detial = detialEE.getText().toString();

                EEItem = new EmergencyEssntialItem(title,detial,String.valueOf(years),String.valueOf(mounth),String.valueOf(day),String.valueOf(hours),String.valueOf(min));
                EEItem.save();
                tilteEE.setText("");
                detialEE.setText("");
                Toast.makeText(EmergencyEssntialDialogActivity.this, "کار ذخیره شد", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        day = dayOfMonth;
        mounth = (monthOfYear + 1);
        years = year;
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        hours = hourOfDay;
        min = minute;
    }
}
