package ir.mehrdadseyfi.a7habit.Calender;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import ir.mehrdadseyfi.a7habit.R;
import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayClickedListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnMonthChangedListener;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;
import me.toptas.fancyshowcase.DismissListener;
import me.toptas.fancyshowcase.FancyShowCaseView;

public class CalenderActivity extends AppCompatActivity {
    PersianDate today;
    PersianCalendarHandler calendarHandler;
    PersianCalendarView calendarView;
    TextView month;
    TextView year;
    Toolbar tool;
    ListView mylist;
    ImageView add_job;
    int postionAlert;
    List<JobDB> models1;
    int i=0;
    Context mContext=this;
    int j=0;
    LinearLayout layoutHelp;
    FancyShowCaseView mFancyShowCaseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calendarView = (PersianCalendarView) findViewById(R.id.persian_calendar);
        calendarHandler = calendarView.getCalendar();
/////help add
ImageView help=(ImageView)findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyShowCaseView.Builder((Activity) mContext)
                        .focusOn(add_job)
                        .backgroundColor(R.color.primary_light)
                        .title("با استفاده از این دکمه می توانید به برنامه ریزی خود کار اضافه کنید.")
                        .dismissListener(new DismissListener() {
                            @Override
                            public void onDismiss(String id) {
                                // FancyShowCaseView is dismissed by user
                                new FancyShowCaseView.Builder((Activity) mContext)
                                        .focusOn(calendarView)
                                        .title("دراین تقویم با کلیک بروی هر روز می توانید برنامه ان روز را مشاهده کنید")
                                        .backgroundColor(R.color.primary_light)
                                        .titleStyle(R.style.s, Gravity.BOTTOM | Gravity.CENTER)
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
        });

        setTodayList();
        setToday();

        today = calendarHandler.getToday();
        add_job=(ImageView) findViewById(R.id.add_job);

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
//    image backgroun ba if
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
//    public void help(){
//        if (helpcount==1)
//        {
//            layoutHelp.setVisibility(View.GONE);
//        }else {
//            help_gone.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("count", 1).commit();
//                    layoutHelp.setVisibility(View.GONE);
//                }
//            });
//        }
//    }

}
