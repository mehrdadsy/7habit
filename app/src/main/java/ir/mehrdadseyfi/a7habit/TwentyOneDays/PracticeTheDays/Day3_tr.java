package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.Vista.AddDialogActivity;
import ir.mehrdadseyfi.a7habit.Vista.FDdatabase;
import ir.mehrdadseyfi.a7habit.Vista.FDlistAdapter;
import ir.mehrdadseyfi.a7habit.Vista.FeragmentDream;
import ir.mehrdadseyfi.a7habit.Vista.VistaActivity;

public class Day3_tr extends AppCompatActivity {
Days3DB days3DB;
    ListView mylist;
    Days3Adapter adapter;
    List<Days3DB> models;
    int postionalret;

    Context mContext=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_tr);

       ImageView img=(ImageView)findViewById(R.id.add_days3_tr);

        creatList();
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 postionalret=position;
                AlertPopup();
            }
        });
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Day3_tr.this, DialogDays4Add.class);
                intent.putExtra("id", models.get(position).getId());
                startActivity(intent);
                return true;
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Day3_tr.this, DialogDays3Add.class));

            }
        });
    }
    public void creatList(){

           models = Days3DB.listAll(Days3DB.class);
           adapter = new Days3Adapter(models, mContext);
           mylist = (ListView) findViewById(R.id.mylist_days3);
           mylist.setAdapter(adapter);
//           BackGroundIf();

    }
//    public void BackGroundIf() {
//        ImageView imgBackGround = (ImageView)findViewById(R.id.img);
//        int i=models.size();
//        if (i == 0) {
//            imgBackGround.setImageResource(R.drawable.noting);
//
//        } else {
//
//            imgBackGround.setImageDrawable(null);
//        }
//    }
    @Override
    public void onStart() {
        creatList();
        super.onStart();
    }

    @Override
    public void onResume() {
        creatList();
        super.onResume();
    }
    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف نگرانی خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        Days3DB books = Days3DB.findById(Days3DB.class, models.get(postionalret).getId());
                        books.delete();
                        Toast.makeText(mContext, "حذف نگرانی انجام شد", Toast.LENGTH_SHORT).show();
                        creatList();


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
    }

