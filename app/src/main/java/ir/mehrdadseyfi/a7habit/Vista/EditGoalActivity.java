package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ir.mehrdadseyfi.a7habit.Calender.JobDB;
import ir.mehrdadseyfi.a7habit.R;

public class EditGoalActivity extends AppCompatActivity {
        Long id;
    EditText editgoal;
    EditText editgola_d;
    List<String> list;
    Spinner spinner;
    FGdatabase book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goal);
        spinner = (Spinner) findViewById(R.id.soin_role_eg);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 1L);
         book1 = FGdatabase.findById(FGdatabase.class, id);
        editgoal = (EditText) findViewById(R.id.title_eg);
        editgola_d = (EditText) findViewById(R.id.detial_eg);
        editgoal.setText(book1.getName());
        editgola_d.setText(book1.getDetial());
        list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        addSpineritem();

        spinner.setAdapter(adapter);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FGdatabase book = FGdatabase.findById(FGdatabase.class, id);
                String name = editgoal.getText().toString();
                String detail = editgola_d.getText().toString();
                book.setName(name);
                book.setDetial(detail);
                book.setRole(spinner.getSelectedItem().toString());
                book.save();
                String update = "UPDATE job_DB set goal='"+name+"'"+"  WHERE  goal = '" + book1.getName() + "'";
                JobDB.executeQuery(update);
                finish();
            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void addSpineritem() {
        List<FRdatabase> models = FRdatabase.listAll(FRdatabase.class);
        for (int i = 0; i < models.size(); i++) {
            list.add(models.get(i).getName());
        }

    }
}
