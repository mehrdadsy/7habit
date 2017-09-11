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
import android.widget.TextView;
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
    RadioGroup chose;
    int chosing=0;
    TextView txtStartDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        title = (EditText) findViewById(R.id.add_job_name);
        detail = (EditText) findViewById(R.id.add_job_detial);
        txtStartDate=(TextView)findViewById(R.id.start_datee);
        //add goal to spin
        spinGoal = (Spinner) findViewById(R.id.spin_goal);
        list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        addSpinGoal();
        spinGoal.setAdapter(adapter);
        //radio group selsevt
        chose = (RadioGroup) findViewById(R.id.chose_repeate);
        chose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.monthly) {
                    chosing=1;
                } else if (checkedId == R.id.weekly) {
                    chosing=2;
                } else if (checkedId == R.id.dialy) {
                    chosing=3;

                } else {

                    chosing=0;
                }

            }

        });

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
                        if (years != 0) {
                            addjob();
                            // repate chose
                            switch (chosing){
                                case 1:setreapteMonthly();
                                    break;
                                case 2:setRepateWeekly();
                                    break;
                                case 3:setRepateDialy();
                                    break;
                                default:
                                    Toast.makeText(AddJobActivity.this, "این کار تکرار ندارد", Toast.LENGTH_SHORT).show();
                            }


                            finish();
                        } else {
                            Toast.makeText(AddJobActivity.this, "لطفا زمان  آغاز کار  را وارد کنید ", Toast.LENGTH_SHORT).show();

                        }
                    }
                }


            }
        });

//cancel
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        String minu;
        if (min==0){
             minu=String.valueOf(min)+"0";
        }else {
            minu=String.valueOf(min);
        }
        txtStartDate.setText(String.valueOf("زمان اغاز"+"\n"+years+"/"+mounth+"/"+day+"\n"+hours+":"+minu ));

    }


    public void addjob() {
        String name = title.getText().toString();
        String dtial = detail.getText().toString();
        String goal = spinGoal.getSelectedItem().toString();


        JobDB jobAdd = new JobDB(name, dtial, goal, String.valueOf(years), String.valueOf(mounth), String.valueOf(day), String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

        jobAdd.save();


        Toast.makeText(this, jobAdd.getSqlName(), Toast.LENGTH_SHORT).show();
    }

    public void addSpinGoal() {
        models = FGdatabase.listAll(FGdatabase.class);
        for (int i = 0; i < models.size(); i++) {
            list.add(models.get(i).getName());
        }
    }


    public void setRepateDialy() {


        int dayr = day;
        int mounthr = mounth;
        int yearr = years;
        int maxdaymounth;
        for (int i = 0; i < 5; i++) {
            dayr++;
            if (mounthr < 7) {
                maxdaymounth = 32;
            } else {
                maxdaymounth = 31;
            }
            if (dayr < maxdaymounth) {

                String yearj = String.valueOf(yearr);
                String mounthj = String.valueOf(mounthr);

                String dayj = String.valueOf(dayr);
                Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                String name = title.getText().toString();
                String dtial = detail.getText().toString();
                String goal = spinGoal.getSelectedItem().toString();

                JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                jobAdd.save();
            } else {

                dayr -= maxdaymounth - 1;

                if (mounthr < 12) {
                    mounthr += 1;
                    String yearj = String.valueOf(yearr);
                    String mounthj = String.valueOf(mounthr);

                    String dayj = String.valueOf(dayr);
                    Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                    String name = title.getText().toString();
                    String dtial = detail.getText().toString();
                    String goal = spinGoal.getSelectedItem().toString();

                    JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                    jobAdd.save();
                } else {
                    mounthr -= 11;
                    yearr += 1;
                    String yearj = String.valueOf(yearr);
                    String mounthj = String.valueOf(mounthr);

                    String dayj = String.valueOf(dayr);
                    Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                    String name = title.getText().toString();
                    String dtial = detail.getText().toString();
                    String goal = spinGoal.getSelectedItem().toString();

                    JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                    jobAdd.save();

                }

            }


        }
    }

    public void setreapteMonthly() {
        int dayr;
        if (day == 31) {
            dayr = day - 1;
        } else {
            dayr = day;
        }
        int mounthr = mounth;
        int yearr = years;
        for (int i = 0; i < 5; i++) {

            if (mounthr < 12) {
                mounthr += 1;
                String yearj = String.valueOf(yearr);
                String mounthj = String.valueOf(mounthr);

                String dayj = String.valueOf(dayr);
                Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                String name = title.getText().toString();
                String dtial = detail.getText().toString();
                String goal = spinGoal.getSelectedItem().toString();

                JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                jobAdd.save();
            } else {
                mounthr -= 11;
                yearr += 1;
                String yearj = String.valueOf(yearr);
                String mounthj = String.valueOf(mounthr);

                String dayj = String.valueOf(dayr);
                Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                String name = title.getText().toString();
                String dtial = detail.getText().toString();
                String goal = spinGoal.getSelectedItem().toString();

                JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                jobAdd.save();

            }

        }


    }

    public void setRepateWeekly() {


        int dayr = day;
        int mounthr = mounth;
        int yearr = years;
        int maxdaymounth;
        for (int i = 0; i < 5; i++) {
            dayr += 7;
            if (mounthr < 7) {
                maxdaymounth = 32;
            } else {
                maxdaymounth = 31;
            }
            if (dayr < maxdaymounth) {

                String yearj = String.valueOf(yearr);
                String mounthj = String.valueOf(mounthr);

                String dayj = String.valueOf(dayr);
                Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                String name = title.getText().toString();
                String dtial = detail.getText().toString();
                String goal = spinGoal.getSelectedItem().toString();

                JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                jobAdd.save();
            } else {

                dayr -= maxdaymounth - 1;

                if (mounthr < 12) {
                    mounthr += 1;
                    String yearj = String.valueOf(yearr);
                    String mounthj = String.valueOf(mounthr);

                    String dayj = String.valueOf(dayr);
                    Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                    String name = title.getText().toString();
                    String dtial = detail.getText().toString();
                    String goal = spinGoal.getSelectedItem().toString();

                    JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                    jobAdd.save();
                } else {
                    mounthr -= 11;
                    yearr += 1;
                    String yearj = String.valueOf(yearr);
                    String mounthj = String.valueOf(mounthr);

                    String dayj = String.valueOf(dayr);
                    Toast.makeText(this, yearj + mounthj + dayj, Toast.LENGTH_SHORT).show();
                    String name = title.getText().toString();
                    String dtial = detail.getText().toString();
                    String goal = spinGoal.getSelectedItem().toString();

                    JobDB jobAdd = new JobDB(name, dtial, goal, yearj, mounthj, dayj, String.valueOf(hours), String.valueOf(min), String.valueOf(eHours), String.valueOf(eMin), goal);

                    jobAdd.save();

                }

            }


        }
    }


}



