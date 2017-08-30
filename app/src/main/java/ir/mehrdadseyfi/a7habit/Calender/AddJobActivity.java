package ir.mehrdadseyfi.a7habit.Calender;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import java.util.ArrayList;
import java.util.List;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.Vista.FGdatabase;
import ir.mehrdadseyfi.a7habit.Vista.FRdatabase;

public class AddJobActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    ImageView startDate;
    ImageView endDate;
    TimePicker endTime;
    List<String> list;
    int hours;
    int min;
    int years;
    int mounth;
    int day;
    int eHours;
    int eMin;
    String repate;
    Spinner spinGoal;
    EditText title;
    EditText detail;
    List<FGdatabase> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        title = (EditText) findViewById(R.id.add_job_name);
        detail = (EditText) findViewById(R.id.add_job_detial);
        choserepete();
        //add goal to spin
        spinGoal = (Spinner) findViewById(R.id.spin_goal);
        list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        addSpinGoal();
        spinGoal.setAdapter(adapter);


        //click on save buuton
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().matches("")) {
                    Toast.makeText(AddJobActivity.this, "لطفا تمام فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                } else {
                    if (models.size() == 0) {
                        Toast.makeText(AddJobActivity.this, "لطفا در بخش اهداف یک هدف وارد کنید ", Toast.LENGTH_SHORT).show();

                    } else {
                        addjob();
                        finish();
                    }
                }


            }
        });


        //
        endTime = (TimePicker) findViewById(R.id.end_hours);
        endTime.setIs24HourView(true);
        //give hours
        if (Build.VERSION.SDK_INT < 23) {
            eHours = endTime.getCurrentHour();
            eMin = endTime.getCurrentMinute();

        } else {
            eHours = endTime.getHour();
            eMin = endTime.getMinute();
        }

        startDate = (ImageView) findViewById(R.id.start_date);
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


    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        hours = hourOfDay;
        min = minute;

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        day = dayOfMonth;
        mounth = (monthOfYear + 1);
        years = year;

    }


    public void addjob() {
        String name = title.getText().toString();
        String dtial = detail.getText().toString();
        String goal = spinGoal.getSelectedItem().toString();


        JobDB jobAdd = new JobDB(name, dtial, goal, String.valueOf(years), String.valueOf(mounth), String.valueOf(day), String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

        jobAdd.save();

        Toast.makeText(this,jobAdd.getSqlName(), Toast.LENGTH_SHORT).show();
    }

    public void addSpinGoal() {
        models = FGdatabase.listAll(FGdatabase.class);
        for (int i = 0; i < models.size(); i++) {
            list.add(models.get(i).getName());
        }
    }

    public void choserepete() {
        RadioGroup chose = (RadioGroup) findViewById(R.id.chose_repeate);
        chose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.monthly) {

                    repate = "monthly";


                } else if (checkedId == R.id.weekly) {

                    repate = "weekly";

                } else if (checkedId == R.id.dialy) {


                    repate = "dialy";
                } else {

                    repate = "one";

                }

            }

        });
    }


}
