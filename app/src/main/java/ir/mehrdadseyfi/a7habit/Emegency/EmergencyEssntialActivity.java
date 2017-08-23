package ir.mehrdadseyfi.a7habit.Emegency;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class EmergencyEssntialActivity extends AppCompatActivity {
    EmergencyEssntialItem item;
    ListView LV;
    List<EmergencyEssntialItem> models;
    Context mContext = this;
    int postionAlert;
    int i = 0;
    ImageView imgBackGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial);
        LV = (ListView) findViewById(R.id.mylist_ee);
        AddItemEE();


//        if (models.size()==0) {
//            final int sdk = android.os.Build.VERSION.SDK_INT;
//            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//                back_ground.setBackgroundDrawable( getResources().getDrawable(R.drawable.ic_launcher) );
//            } else {
//                back_ground.setBackground( getResources().getDrawable(R.drawable.ic_launcher));
//            }
//        }


        ImageView img_toolbar = (ImageView) findViewById(R.id.del);
        img_toolbar.setImageResource(R.drawable.ic_note_add_black_48dp);
        img_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmergencyEssntialActivity.this, EmergencyEssntialDialogActivity.class));
            }
        });
        LV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;
                AlertPopup();
                return true;
            }
        });
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EmergencyEssntialActivity.this, EmergencyEssntialShowEditActivity.class);
                intent.putExtra("id", models.get(position).getId());
                startActivity(intent);

            }
        });
    }

    public void AddItemEE() {
        models = EmergencyEssntialItem.listAll(EmergencyEssntialItem.class);
        EmergencyEssntialListAdapter adpter = new EmergencyEssntialListAdapter(models, mContext);
        i = models.size();
        BackGroundIf();



        try {
            LV.setAdapter(adpter);


        } catch (Exception e) {

        }
    }

    @Override
    protected void onResume() {
        AddItemEE();
        super.onResume();
    }

    @Override
    protected void onStart() {
        AddItemEE();
        super.onStart();
    }

    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف کار خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        EmergencyEssntialItem books = EmergencyEssntialItem.findById(EmergencyEssntialItem.class, models.get(postionAlert).getId());
                        books.delete();
                        Toast.makeText(EmergencyEssntialActivity.this, "حذف کار انجام شد", Toast.LENGTH_SHORT).show();
                        AddItemEE();

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

    public void BackGroundIf() {
        imgBackGround = (ImageView) findViewById(R.id.img);

        if (i == 0) {
            imgBackGround.setImageResource(R.drawable.noting);

        } else {
            imgBackGround.setImageDrawable(null);
        }
    }
}
