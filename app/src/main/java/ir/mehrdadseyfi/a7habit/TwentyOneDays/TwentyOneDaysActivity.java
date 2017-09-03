package ir.mehrdadseyfi.a7habit.TwentyOneDays;

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

import ir.mehrdadseyfi.a7habit.R;

public class TwentyOneDaysActivity extends AppCompatActivity {
    Context mContext = this;
    int curlevel;
    ImageView level1;
    ImageView level2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one_days);
         level1=(ImageView)findViewById(R.id.level1);
         level2=(ImageView)findViewById(R.id.level2);
        curlevel=PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel",0);
        //point
        ImageView point=(ImageView)findViewById(R.id.point);
        Animation animationHelp = AnimationUtils.loadAnimation(TwentyOneDaysActivity.this, R.anim.shake);
        point.startAnimation(animationHelp);
       //add 21 days
        ImageView add_21=(ImageView)findViewById(R.id.add_21);
        add_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwentyOneDaysActivity.this, MainStart21DayActivity.class));
            }
        });
        //reset
        ImageView reset=(ImageView)findViewById(R.id.restart);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               curlevel++;
            }
        });
       palylevel();




    }
    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف  خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putBoolean("startsate", false).commit();




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
    public void palylevel(){
        switch (curlevel){
            case 1:

                 level1=(ImageView)findViewById(R.id.level1);
                level1.setImageResource(R.drawable.sq01);
                level1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      if (curlevel==1)
                        startActivity(new Intent(TwentyOneDaysActivity.this, ShowTipActivity.class));
                    }
                });

                break;
            case 2:


                level1.setImageResource(R.drawable.sq04);
               level2.setImageResource(R.drawable.sq02);
                level2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TwentyOneDaysActivity.this, ShowTipActivity.class));
                    }
                });


                break;
            case 0: Toast.makeText(mContext, "fuck0", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(mContext, "fuck", Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    protected void onResume() {
        curlevel=PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel",0);

        palylevel();
        super.onResume();
    }

    @Override
    protected void onStart() {
        curlevel=PreferenceManager.getDefaultSharedPreferences(this).getInt("curlevel",0);

        palylevel();
        super.onStart();
    }
}
