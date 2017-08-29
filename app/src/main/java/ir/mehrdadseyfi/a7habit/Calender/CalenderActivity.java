package ir.mehrdadseyfi.a7habit.Calender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;
import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
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
         calendarView  = (PersianCalendarView) findViewById(R.id.persian_calendar);
         calendarHandler = calendarView.getCalendar();
         today = calendarHandler.getToday();
        add_job=(ImageView)findViewById(R.id.add_job);
        textViewShow();

    }
    public void textViewShow(){
        month=(TextView)findViewById(R.id.month);
        year=(TextView)findViewById(R.id.year);
        month.setText(calendarHandler.getMonthName(new PersianDate(1399,today.getMonth(),10) ));
        year.setText( String.valueOf(today.getYear()));

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate persianDate) {

                month.setText(calendarHandler.getMonthName( persianDate));
                year.setText(String.valueOf(persianDate.getYear()));
            }
        });




    }
    public void setAdd_job(){

    }
}
