package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class ShowGoalRoleActivity extends AppCompatActivity {
    long id;
    EditText editRole;
    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goal_role);
        editRole=(EditText)findViewById(R.id.edit_role_name);

        Intent intent = getIntent();
         role= intent.getStringExtra("role");
        editRole.setText(role);
        id=intent.getLongExtra("id",1L);
        TextView txt=(TextView)findViewById(R.id.text);
        txt.setText("هدف های مربوط به نقش"+" "+role);
        List<FGdatabase> notes = FGdatabase.find(FGdatabase.class, "role = ?" , role);
        ListView mylist=(ListView)findViewById(R.id.mylist_rg);
        FGlistAdapter adapter=new FGlistAdapter(notes,this);
        mylist.setAdapter(adapter);
        findViewById(R.id.edit_role).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FRdatabase book = FRdatabase.findById(FRdatabase.class, id);
                book.setName(editRole.getText().toString());
                book.save(); //
                String name=role;
                List<FGdatabase> notes = FGdatabase.find(FGdatabase.class, "role = ?" , name);

                for (int i = 0; i < notes.size(); i++) {
                    FGdatabase books1 = FGdatabase.findById(FGdatabase.class, notes.get(i).getId());
                    books1.setRole(editRole.getText().toString());
                    books1.save();
                }
                finish();



            }
        });



    }

}
