package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LongGoalActivity extends AppCompatActivity {
    List<LongGoalModule> models;

    GoalDB test;
    String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_goal);
        test = new GoalDB(this, "longdb", null, 1);
        name=new String[Integer.parseInt(test.getGoalID())];
        final LongGoalAdapter adapter = new LongGoalAdapter(name, this);
        final ListView mylist = (ListView) findViewById(R.id.list_long_goal);

        findViewById(R.id.add_long_goal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LongGoalActivity.this, Dialog.class));
            }
        });
        findViewById(R.id.add_long_goal_R).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=1;i<name.length;i++){
                    name[i]= test.getGoalName(String.valueOf(i));
                }
                mylist.setAdapter(adapter);

            }
        });


    }


}

