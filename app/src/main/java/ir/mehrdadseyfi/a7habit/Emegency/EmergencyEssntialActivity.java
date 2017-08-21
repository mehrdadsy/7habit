package ir.mehrdadseyfi.a7habit.Emegency;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class EmergencyEssntialActivity extends AppCompatActivity {
EmergencyEssntialItem item;
    ListView LV;
    List<EmergencyEssntialItem>models;
    Context mContext=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial);
        LV=(ListView)findViewById(R.id.mylist_ee);
//        List<EmergencyEssntialItem> books = EmergencyEssntialItem.listAll(EmergencyEssntialItem.class);
        AddItemEE();
//        EmergencyEssntialListAdapter adpter=new EmergencyEssntialListAdapter(books,this);
//        LV.setAdapter(adpter);

        findViewById(R.id.add_E_E).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmergencyEssntialActivity.this, EmergencyEssntialDialogActivity.class));
            }
        });
    }
    public void AddItemEE() {
        models = EmergencyEssntialItem.listAll(EmergencyEssntialItem.class);
        EmergencyEssntialListAdapter adpter = new EmergencyEssntialListAdapter(models, mContext);
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
}
