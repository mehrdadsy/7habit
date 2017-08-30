package ir.mehrdadseyfi.a7habit.Calender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.Vista.VistaActivity;
import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayClickedListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnMonthChangedListener;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;

public class CalenderActivity extends AppCompatActivity {
    PersianDate today;
    PersianCalendarHandler calendarHandler;
    PersianCalendarView calendarView;
    TextView month;
    TextView year;
    ImageView add_job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        calendarView = (PersianCalendarView) findViewById(R.id.persian_calendar);
        calendarHandler = calendarView.getCalendar();
        ImageView help = (ImageView) findViewById(R.id.help);
        //TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalenderActivity.this, VistaActivity.class));

            }
        });
        today = calendarHandler.getToday();
        add_job = (ImageView) findViewById(R.id.add_job);
        add_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalenderActivity.this, AddJobActivity.class));

            }
        });
        textViewShow();
        showJobDay();

    }

    public void textViewShow() {
        month = (TextView) findViewById(R.id.month);
        year = (TextView) findViewById(R.id.year);
        month.setText(calendarHandler.getMonthName(new PersianDate(1399, today.getMonth(), 10)));
        year.setText(String.valueOf(today.getYear()));

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate persianDate) {

                month.setText(calendarHandler.getMonthName(persianDate));
                year.setText(String.valueOf(persianDate.getYear()));
            }
        });


    }

    public void setAdd_job() {

    }

    public void showJobDay() {
        calendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate persianDate) {
                Intent intent = new Intent(CalenderActivity.this, ShowDayJobActivity.class);
                intent.putExtra("year", String.valueOf(persianDate.getYear()));
                intent.putExtra("month",String.valueOf(persianDate.getMonth()) );
                intent.putExtra("day",String.valueOf(persianDate.getDayOfMonth()) );
                startActivity(intent);


            }
        });
    }
}
