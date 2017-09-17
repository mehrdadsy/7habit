package ir.mehrdadseyfi.a7habit.Calender;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
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
import me.toptas.fancyshowcase.DismissListener;
import me.toptas.fancyshowcase.FancyShowCaseView;

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
    Context mContext=this;
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
        endTime = (TimePicker) findViewById(R.id.end_hours);
        endTime.setIs24HourView(true);
        //add goal to spin
        spinGoal = (Spinner) findViewById(R.id.spin_goal);
        list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spiner_custom, list);
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
        ImageView help=(ImageView)findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyShowCaseView.Builder((Activity) mContext)
                        .focusOn(startDate)
                        .backgroundColor(R.color.primary_light)
                        .title("با استفاده از این دکمه می توانید ساعت و روز آغاز کار خود را بنویسید")
                        .dismissListener(new DismissListener() {
                            @Override
                            public void onDismiss(String id) {
                                // FancyShowCaseView is dismissed by user
                                new FancyShowCaseView.Builder((Activity) mContext)
                                        .focusOn(spinGoal)
                                        .title("در این قسمت می توانید هدف مربوط به کار خود را بنویسید دقت کنید که تمامی کار ها باید هدف داشته باشند")
                                        .backgroundColor(R.color.primary_light)
                                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)
                                        .dismissListener(new DismissListener() {
                                            @Override
                                            public void onDismiss(String id) {
                                                // FancyShowCaseView is dismissed by user
                                                new FancyShowCaseView.Builder((Activity) mContext)
                                                        .focusOn(chose)
                                                        .title("در این قسمت می توانید دفعات تکرار هر کار را بنویسید")
                                                        .backgroundColor(R.color.primary_light)
                                                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)
                                                        .dismissListener(new DismissListener() {
                                                            @Override
                                                            public void onDismiss(String id) {
                                                                // FancyShowCaseView is dismissed by user
                                                            }

                                                            @Override
                                                            public void onSkipped(String id) {
                                                                // Skipped because it was setup to shown only once and shown before
                                                            }
                                                        })
                                                        .build()
                                                        .show();
                                            }

                                            @Override
                                            public void onSkipped(String id) {
                                                // Skipped because it was setup to shown only once and shown before
                                            }
                                        })
                                        .build()
                                        .show();
                            }

                            @Override
                            public void onSkipped(String id) {
                                // Skipped because it was setup to shown only once and shown before
                            }
                        })
                        .build()
                        .show();
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
        if (min<10){
             minu="0"+String.valueOf(min);
        }else {
            minu=String.valueOf(min);
        }
        txtStartDate.setText(String.valueOf("زمان اغاز"+" "+years+"/"+mounth+"/"+day+"  "+hours+":"+minu ));

    }


    public void addjob() {
        String name = title.getText().toString();
        String dtial = detail.getText().toString();
        String goal = spinGoal.getSelectedItem().toString();
        String minu;
        if (min<10){
            minu="0"+String.valueOf(min);
        }else {
            minu=String.valueOf(min);
        }

        //give hours
        if (Build.VERSION.SDK_INT < 23) {
            eHours = endTime.getCurrentHour();
            eMin = endTime.getCurrentMinute();

        } else {
            eHours = endTime.getHour();
            eMin = endTime.getMinute();
        }
//    String miner;
//        if (eMin<10){
//            miner="0"+String.valueOf(eMin);
//        }else {
//            miner=String.valueOf(eMin);
//        }

        JobDB jobAdd = new JobDB(name, dtial, goal, String.valueOf(years), String.valueOf(mounth), String.valueOf(day), String.valueOf(hours), String.valueOf(minu), String.valueOf(eHours), String.valueOf(eMin), goal);

        jobAdd.save();


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
        for (int i = 0; i < 200; i++) {
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
        for (int i = 0; i < 12; i++) {

            if (mounthr < 12) {
                mounthr += 1;
                String yearj = String.valueOf(yearr);
                String mounthj = String.valueOf(mounthr);

                String dayj = String.valueOf(dayr);
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
        for (int i = 0; i < 50; i++) {
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



