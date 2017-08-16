package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class LongGoalActivity extends AppCompatActivity {
    List<LongGoalModule> models;

    GoalDB test;
    String[] name;
    LongGoalAdapter adapter;
    ListView mylist;
    int[] catPhoto;
    String[]date;

    @Override
    protected void onResume() {
        listItemAdd();
        super.onResume();
    }

    @Override
    protected void onStart() {
        listItemAdd();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_goal);
        test = new GoalDB(this, "longdb", null, 1);
        listItemAdd();
        findViewById(R.id.add_long_goal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LongGoalActivity.this, Dialog.class));
            }
        });
        findViewById(R.id.add_long_goal_R).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mylist.setAdapter(adapter);

            }
        });


    }

 public void listItemAdd() {
     name = new String[Integer.parseInt(test.getGoalID()) + 1];
     catPhoto = new int[Integer.parseInt(test.getGoalID()) + 1];
     date = new String[Integer.parseInt(test.getGoalID()) + 1];


     for (int i = 1; i < name.length; i++) {
         name[i] = test.getGoalName(String.valueOf(i));
         date[i] = test.getGoalDate(String.valueOf(i));
            switch (test.getGoalcat(String.valueOf(i))){
                case "تفریحی/مسافرتی":
                    catPhoto[i]=R.mipmap.ic_launcher;
                    break ;
                case "ورزشی":
                    catPhoto[i]=R.mipmap.ic_launcher;
                    break ;
                case "آموزشی":
                    catPhoto[i]=R.mipmap.ic_launcher;
                    break ;
                case "شغلی":
                    catPhoto[i]=R.mipmap.ic_launcher;
                    break ;
                case "مالی":
                    catPhoto[i]=R.mipmap.ic_launcher;
                    break ;
                default:
                    catPhoto[i]=R.mipmap.ic_launcher;
            }
     }
     adapter = new LongGoalAdapter(name, this, catPhoto,date);
     mylist = (ListView) findViewById(R.id.list_long_goal);
     mylist.setAdapter(adapter);
     mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    test.deleteRow(position);
             return true;
         }
     });


 }
}

