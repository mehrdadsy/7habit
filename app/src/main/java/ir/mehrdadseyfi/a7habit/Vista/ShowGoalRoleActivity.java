package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class ShowGoalRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goal_role);
        Intent intent = getIntent();
        String role= intent.getStringExtra("role");
        TextView txt=(TextView)findViewById(R.id.text);
        txt.setText("هدف های مربوط به نقش"+" "+role);
        List<FGdatabase> notes = FGdatabase.find(FGdatabase.class, "role = ?" , role);
        ListView mylist=(ListView)findViewById(R.id.mylist_rg);
        FGlistAdapter adapter=new FGlistAdapter(notes,this);
        mylist.setAdapter(adapter);


    }
}
