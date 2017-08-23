package ir.mehrdadseyfi.a7habit.Emegency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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
    TextView calenderText;
    EmergencyEssntialItem EEItem;
    Spinner cat;
    String catToDB;
    int hours;
    int min;
    int years;
    int mounth;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial_dialog);


        cat = (Spinner) findViewById(R.id.spinEE);

        tilteEE = (EditText) findViewById(R.id.add_title_EE);
        detialEE = (EditText) findViewById(R.id.add_detial_EE);
        ImageView imgBtn = (ImageView) findViewById(R.id.calender);
        imgBtn.setImageResource(R.drawable.alarmdialog);
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
                if (title.matches("") && detial.matches("") ) {
                    Toast.makeText(EmergencyEssntialDialogActivity.this, "لطفا موارد خواسته شده و تاریخ را وارد کنید", Toast.LENGTH_SHORT).show();
                } else {
                    EEItem = new EmergencyEssntialItem(title, detial, "ee", catToDB, String.valueOf(years), String.valueOf(mounth), String.valueOf(day), String.valueOf(hours), String.valueOf(min));
                    EEItem.save();
                    tilteEE.setText("");
                    detialEE.setText("");
                    Toast.makeText(EmergencyEssntialDialogActivity.this, "کار ذخیره شد", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(EmergencyEssntialDialogActivity.this, "ذخیره کار لغو شد", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        day = dayOfMonth;
        mounth = (monthOfYear + 1);
        years = year;
        calenderText=(TextView)findViewById(R.id.calender_text);
        calenderText.setText(years+"/"+mounth+"/"+day+"\n"+
        hours+":"+min);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        hours = hourOfDay;
        min = minute;
    }

    public void addImageCat() {
        switch (cat.getSelectedItem().toString()) {
            case "تفریحی/مسافرتی":
                catToDB = String.valueOf(R.drawable.ic_launcher);
                break;
            case "ورزشی":
                catToDB = "1";
                break;
            case "آموزشی":
                catToDB = "1";
                break;
            case "شغلی":
                catToDB = "1";
                break;
            case "مالی":
                catToDB = "1";
                break;
            default:
                catToDB = "1";
                break;

        }
    }
}
