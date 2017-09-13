package ir.mehrdadseyfi.a7habit.Calender;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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
    ListView mylist;
    int postionAlert;
    List<JobDB> models1;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        calendarView = (PersianCalendarView) findViewById(R.id.persian_calendar);
        calendarHandler = calendarView.getCalendar();
        ImageView help = (ImageView) findViewById(R.id.help);

        setTodayList();
        setToday();
        //TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalenderActivity.this, HelpActivity.class));

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
        //delete itemmmmmmmmmmmmm
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;
                AlertPopup();

                return true;
            }
        });

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
              List<JobDB> models=JobDB.find(JobDB.class,"year= ? and mount= ? and day= ?", String.valueOf(persianDate.getYear()),String.valueOf(persianDate.getMonth()),String.valueOf(persianDate.getDayOfMonth()));
               if(models.size()==0){
                   Toast.makeText(CalenderActivity.this, "کاری برای این روز وجود ندارد", Toast.LENGTH_SHORT).show();
               }else {
                   Intent intent = new Intent(CalenderActivity.this, ShowDayJobActivity.class);
                   intent.putExtra("year", String.valueOf(persianDate.getYear()));
                   intent.putExtra("month", String.valueOf(persianDate.getMonth()));
                   intent.putExtra("day", String.valueOf(persianDate.getDayOfMonth()));
                   startActivity(intent);
               }

            }
        });
    }
    public void setTodayList(){
        PersianDate today1 = calendarHandler.getToday();
         models1=JobDB.find(JobDB.class,"year= ? and mount= ? and day= ?", String.valueOf(today1.getYear()),String.valueOf(today1.getMonth()),String.valueOf(today1.getDayOfMonth()));
        ShowJobDayListAdapter adapter=new ShowJobDayListAdapter(models1,this);
         mylist=(ListView)findViewById(R.id.my_today_list);
        mylist.setAdapter(adapter);
        i = models1.size();
//        BackGroundIf();

    }

    @Override
    protected void onStart() {
        setTodayList();
        super.onStart();
    }

    @Override
    protected void onResume() {
        setTodayList();

        super.onResume();
    }
    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

//tiltle
        alertDialog.setTitle("توجه");
        alertDialog.setIconAttribute(R.drawable.del);

//maten dialog
        alertDialog.setMessage("آیا از حذف کار خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "بله",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String del = "DELETE FROM job_DB WHERE name =" + " '" + models1.get(postionAlert).getName() + "' and  goal = '" + models1.get(postionAlert).getGoal() + "'";
                        JobDB.executeQuery(del);
                        Toast.makeText(CalenderActivity.this, "حذف کار انجام شد", Toast.LENGTH_SHORT).show();
                        setTodayList();

                    }

                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "خیر",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }

                });


        alertDialog.show();


    }
    public void setToday(){
        PersianDate today1 = calendarHandler.getToday();
       TextView today=(TextView)findViewById(R.id.today);
       today.setText(  String.valueOf(today1.getDayOfMonth())+" "+
        String.valueOf(calendarHandler.getMonthName(today1))+" "+String.valueOf(today1.getYear())
       );

    }
    //image backgroun ba if
//    public void BackGroundIf() {
//        ImageView imgBackGround = (ImageView) findViewById(R.id.img);
//
//        if (i == 0) {
//            imgBackGround.setImageResource(R.drawable.noting);
//
//        } else {
//
//            imgBackGround.setImageDrawable(null);
//        }
//    }
}
