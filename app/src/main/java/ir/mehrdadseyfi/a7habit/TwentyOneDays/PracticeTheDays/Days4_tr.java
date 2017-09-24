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

public class Days4_tr extends AppCompatActivity {
    Days3DB days3DB;
    ListView mylist;
    Days3Adapter adapter;
    List<Days3DB> models;
    int postionalret;
    Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days4_tr);
         creatList();
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            postionalret=position;

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

}
