package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ir.mehrdadseyfi.a7habit.JalaliCalendar;
import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.NOEsstianlEmergencyActivity;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays.*;

public class TwentyOneDaysActivity extends AppCompatActivity {
    Context mContext = this;
    int curlevel;
    ImageView level1;
    ImageView level2;
    ImageView level3;
    ImageView level4;
    ImageView level5;
    ImageView level6;
    ImageView level7;
    ImageView level8;
    ImageView level9;
    ImageView level10;
    ImageView level11;
    ImageView level12;
    ImageView level13;
    ImageView level14;
    ImageView level15;
    ImageView level16;
    ImageView level17;
    ImageView level18;
    ImageView level19;
    ImageView level20;
    ImageView level21;
    ImageView share;
    long d;
    Intent intent;

    long dayMil = 6 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one_days);
        level1 = (ImageView) findViewById(R.id.level1);
        level2 = (ImageView) findViewById(R.id.level2);
        level3 = (ImageView) findViewById(R.id.level3);
        level4 = (ImageView) findViewById(R.id.level4);
        level5 = (ImageView) findViewById(R.id.level5);
        level6 = (ImageView) findViewById(R.id.level6);
        level7 = (ImageView) findViewById(R.id.level7);
        level8 = (ImageView) findViewById(R.id.level8);
        level9 = (ImageView) findViewById(R.id.level9);
        level10 = (ImageView) findViewById(R.id.level10);
        level11 = (ImageView) findViewById(R.id.level11);
        level12 = (ImageView) findViewById(R.id.level12);
        level13 = (ImageView) findViewById(R.id.level13);
        level14 = (ImageView) findViewById(R.id.level14);
        level15 = (ImageView) findViewById(R.id.level15);
        level16 = (ImageView) findViewById(R.id.level16);
        level17 = (ImageView) findViewById(R.id.level17);
        level18 = (ImageView) findViewById(R.id.level18);
        level19 = (ImageView) findViewById(R.id.level19);
        level20 = (ImageView) findViewById(R.id.level20);
        level21 = (ImageView) findViewById(R.id.level21);
        share = (ImageView) findViewById(R.id.share);


        curlevel = PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel", 0);
        //anim
        Animation animationHelp = AnimationUtils.loadAnimation(TwentyOneDaysActivity.this, R.anim.shake);

        //add 21 days
        ImageView add_21 = (ImageView) findViewById(R.id.add_21);
        add_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwentyOneDaysActivity.this, MainStart21DayActivity.class));
            }
        });
        //reset
        ImageView reset = (ImageView) findViewById(R.id.restart);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertPopup();
            }
        });
        palylevel();
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String PM="null";
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT,PM);
//                sendIntent.setType("text/plain");
//                sendIntent.setPackage("org.telegram.messenger");
//                try{
//                    startActivity(sendIntent);
//                }
//                catch (android.content.ActivityNotFoundException ex){
//                    Toast.makeText(getApplicationContext(),"Install Telegram",Toast.LENGTH_LONG).show();
//                }
                startActivity(new Intent(TwentyOneDaysActivity.this, PresentMeActivity.class));

            }
        });

    }

    public void alertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا می خواهید از مرحله اول آغاز کنید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putBoolean("startsate", false).commit();
                        curlevel = PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel", 0);
                        level1.setImageResource(R.drawable.emp);
                        level2.setImageResource(R.drawable.emp);
                        level3.setImageResource(R.drawable.emp);
                        level4.setImageResource(R.drawable.emp);
                        level5.setImageResource(R.drawable.emp);
                        level6.setImageResource(R.drawable.emp);
                        level7.setImageResource(R.drawable.emp);
                        level8.setImageResource(R.drawable.emp);
                        level9.setImageResource(R.drawable.emp);
                        level10.setImageResource(R.drawable.emp);
                        level11.setImageResource(R.drawable.emp);
                        level12.setImageResource(R.drawable.emp);
                        level13.setImageResource(R.drawable.emp);
                        level14.setImageResource(R.drawable.emp);
                        level15.setImageResource(R.drawable.emp);
                        level16.setImageResource(R.drawable.emp);
                        level17.setImageResource(R.drawable.emp);
                        level18.setImageResource(R.drawable.emp);
                        level19.setImageResource(R.drawable.emp);
                        level20.setImageResource(R.drawable.emp);
                        level21.setImageResource(R.drawable.emp);
                        List<Days3DB> books = Days3DB.listAll(Days3DB.class);
                        Days3DB.deleteAll(Days3DB.class);


                    }

                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }

                });


        alertDialog.show();


    }

    public void noTimePopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

//tiltle
        alertDialog.setTitle("");

//maten dialog
        alertDialog.setMessage("دقت داشته باشید که هر مرحله حداقل باید یک روز از مرحله قبلی فاصله زمانی داشته باشد..." + "\n"
                + "در پایان این زمان شما می توانید مرحله بعدی را آغاز کنید");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();


                    }

                });


        alertDialog.show();


    }


    public void palylevel() {
        switch (curlevel) {
            case 1:

                level1 = (ImageView) findViewById(R.id.level1);
                level1.setImageResource(R.drawable.point);

                level1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 1)
                           
                         
                       
                     startActivity(new Intent(TwentyOneDaysActivity.this, days1.class));
                    }
                });

                break;
            case 2:


                level1.setImageResource(R.drawable.prize);
                level2.setImageResource(R.drawable.point);

                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 2) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days2.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 3:

        level1.setImageResource(R.drawable.prize);

                level2.setImageResource(R.drawable.prize);
                level3.setImageResource(R.drawable.point);

                level3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 3) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days3_4.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 4:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
                level3.setImageResource(R.drawable.prize);
                level4.setImageResource(R.drawable.point);

                level4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 4) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days4_tr.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 5:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
                level4.setImageResource(R.drawable.prize);
                level5.setImageResource(R.drawable.point);

                level5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 5) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days5.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 6:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
                level5.setImageResource(R.drawable.prize);
                level6.setImageResource(R.drawable.point);

                level6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 6) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days6.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 7:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
                level6.setImageResource(R.drawable.prize);
                level7.setImageResource(R.drawable.point);

                level7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 7) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days7.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 8:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
                level7.setImageResource(R.drawable.prize);
                level8.setImageResource(R.drawable.point);

                level8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 8) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days8.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 9:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
                level8.setImageResource(R.drawable.prize);
                level9.setImageResource(R.drawable.point);

                level9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 9) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days9.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 10:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
                level9.setImageResource(R.drawable.prize);
                level10.setImageResource(R.drawable.point);

                level10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel ==10) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days10.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 11:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
                level10.setImageResource(R.drawable.prize);
                level11.setImageResource(R.drawable.point);

                level11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 11) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days11.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 12:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
                level11.setImageResource(R.drawable.prize);
                level12.setImageResource(R.drawable.point);

                level12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 12) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days12.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 13:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
                level12.setImageResource(R.drawable.prize);
                level13.setImageResource(R.drawable.point);

                level13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 13) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days13.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 14:
        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

                level13.setImageResource(R.drawable.prize);
                level14.setImageResource(R.drawable.point);

                level14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 14) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days14.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 15:
        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

                level14.setImageResource(R.drawable.prize);
                level15.setImageResource(R.drawable.point);

                level15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 15) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days15.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 16:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

        level14.setImageResource(R.drawable.prize);
                level15.setImageResource(R.drawable.prize);
                level16.setImageResource(R.drawable.point);

                level16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 16) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days16.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 17:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

        level14.setImageResource(R.drawable.prize);
        level15.setImageResource(R.drawable.prize);
                level16.setImageResource(R.drawable.prize);
                level17.setImageResource(R.drawable.point);

                level17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 17) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days17.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 18:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

        level14.setImageResource(R.drawable.prize);
        level15.setImageResource(R.drawable.prize);
        level16.setImageResource(R.drawable.prize);
                level17.setImageResource(R.drawable.prize);
                level18.setImageResource(R.drawable.point);

                level18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 18) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days18.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 19:

        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

        level14.setImageResource(R.drawable.prize);
        level15.setImageResource(R.drawable.prize);
        level16.setImageResource(R.drawable.prize);
        level17.setImageResource(R.drawable.prize);
                level18.setImageResource(R.drawable.prize);
                level19.setImageResource(R.drawable.point);

                level19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 19) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days19.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
    case 20:
        level1.setImageResource(R.drawable.prize);

        level2.setImageResource(R.drawable.prize);
        level3.setImageResource(R.drawable.prize);
        level4.setImageResource(R.drawable.prize);
        level5.setImageResource(R.drawable.prize);
        level6.setImageResource(R.drawable.prize);
        level7.setImageResource(R.drawable.prize);
        level8.setImageResource(R.drawable.prize);
        level9.setImageResource(R.drawable.prize);
        level10.setImageResource(R.drawable.prize);
        level11.setImageResource(R.drawable.prize);
        level12.setImageResource(R.drawable.prize);

        level13.setImageResource(R.drawable.prize);

        level14.setImageResource(R.drawable.prize);
        level15.setImageResource(R.drawable.prize);
        level16.setImageResource(R.drawable.prize);
        level17.setImageResource(R.drawable.prize);
        level18.setImageResource(R.drawable.prize);

                level19.setImageResource(R.drawable.prize);
                level20.setImageResource(R.drawable.point);

                level20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 20) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days20.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
            case 21:
                level1.setImageResource(R.drawable.prize);

                level2.setImageResource(R.drawable.prize);
                level3.setImageResource(R.drawable.prize);
                level4.setImageResource(R.drawable.prize);
                level5.setImageResource(R.drawable.prize);
                level6.setImageResource(R.drawable.prize);
                level7.setImageResource(R.drawable.prize);
                level8.setImageResource(R.drawable.prize);
                level9.setImageResource(R.drawable.prize);
                level10.setImageResource(R.drawable.prize);
                level11.setImageResource(R.drawable.prize);
                level12.setImageResource(R.drawable.prize);

                level13.setImageResource(R.drawable.prize);

                level14.setImageResource(R.drawable.prize);
                level15.setImageResource(R.drawable.prize);
                level16.setImageResource(R.drawable.prize);
                level17.setImageResource(R.drawable.prize);
                level18.setImageResource(R.drawable.prize);

                level19.setImageResource(R.drawable.prize);

                level20.setImageResource(R.drawable.prize);
                level21.setImageResource(R.drawable.point);

                level21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (curlevel == 21) {
                            if (Calendar.getInstance().getTime().getTime() - PreferenceManager.getDefaultSharedPreferences(mContext).getLong("t0", 0) > dayMil) {
                               
                                 
                               
                             startActivity(new Intent(TwentyOneDaysActivity.this, Days21.class));
                            } else {
                                noTimePopup();
                            }
                        }
                    }
                });


                break;
            case 22:
                Toast.makeText(mContext, "END", Toast.LENGTH_SHORT).show();

                level1.setImageResource(R.drawable.prize);

                level2.setImageResource(R.drawable.prize);
                level3.setImageResource(R.drawable.prize);
                level4.setImageResource(R.drawable.prize);
                level5.setImageResource(R.drawable.prize);
                level6.setImageResource(R.drawable.prize);
                level7.setImageResource(R.drawable.prize);
                level8.setImageResource(R.drawable.prize);
                level9.setImageResource(R.drawable.prize);
                level10.setImageResource(R.drawable.prize);
                level11.setImageResource(R.drawable.prize);
                level12.setImageResource(R.drawable.prize);

                level13.setImageResource(R.drawable.prize);

                level14.setImageResource(R.drawable.prize);
                level15.setImageResource(R.drawable.prize);
                level16.setImageResource(R.drawable.prize);
                level17.setImageResource(R.drawable.prize);
                level18.setImageResource(R.drawable.prize);

                level19.setImageResource(R.drawable.prize);

                level20.setImageResource(R.drawable.prize);
                level21.setImageResource(R.drawable.prize);

        }
    }

    @Override
    protected void onResume() {
        curlevel = PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel", 0);

        palylevel();
        super.onResume();
    }

    @Override
    protected void onStart() {
        curlevel = PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel", 0);

        palylevel();
        super.onStart();
    }

}


