package ir.mehrdadseyfi.a7habit.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialItem;
import ir.mehrdadseyfi.a7habit.R;

public class AddDialogActivity extends AppCompatActivity {

    EditText addVist;
    EditText addDtail;
    RadioGroup chose;
    Spinner spinner;
    int i = 0;
    List<String> list;
    TextView spin;
    List<FRdatabase> models;
    Toolbar tool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dialog_vista);


        list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        addSpineritem();
        spin = (TextView) findViewById(R.id.vista_spin);
        spinner = (Spinner) findViewById(R.id.spinEE);
        spinner.setAdapter(adapter);
        addVist = (EditText) findViewById(R.id.add_vista);
        addDtail = (EditText) findViewById(R.id.add_detial_vista);
        chose = (RadioGroup) findViewById(R.id.chose_add);
        chose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.goal_sel) {
                    i = 1;
                    spinner.setVisibility(View.VISIBLE);
                    addDtail.setVisibility(View.VISIBLE);
                    addDtail.setHint(R.string.vista_hint_goal_d);
                    addVist.setHint(R.string.vista_hint_goal);
                    spin.setVisibility(View.VISIBLE);




                } else if (checkedId == R.id.role_sel) {
                    i = 2;
                    addDtail.setVisibility(View.GONE);
                    spinner.setVisibility(View.GONE);
                    addVist.setHint(R.string.vista_hint_role_d);
                    spin.setVisibility(View.GONE);


                } else {
                    i = 3;
                    spinner.setVisibility(View.GONE);
                    addDtail.setVisibility(View.VISIBLE);
                    spin.setVisibility(View.GONE);
                    addDtail.setHint(R.string.vista_hint_dream_d);
                    addVist.setHint(R.string.vista_hint_dream);


                }

            }

        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 3:
                        if (addVist.getText().toString().matches("")) {
                            Toast.makeText(AddDialogActivity.this, "لطفا همه فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                        } else {
                            addDream();
                            finish();
                        }

                        break;
                    case 2:
                        if (addVist.getText().toString().matches("")) {
                            Toast.makeText(AddDialogActivity.this, "لطفا همه فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                        } else {

                            addRole();
                            finish();
                        }
                        break;
                    case 1:
                        if (addVist.getText().toString().matches("")) {
                            Toast.makeText(AddDialogActivity.this, "لطفا همه فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                        } else {
                            if (models.size() == 0) {
                                Toast.makeText(AddDialogActivity.this, "لطفا یک نقش وارد کنید", Toast.LENGTH_SHORT).show();

                            } else {
                                addgoal();
                                finish();

                            }
                        }
                        break;
                    default:
                        Toast.makeText(AddDialogActivity.this, "لطفا هدف یا رویا یا نقشی را انتخاب کنید", Toast.LENGTH_LONG).show();


                }

            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void addgoal() {
        String d = addVist.getText().toString();
        String dd = addDtail.getText().toString();
        String ddd = spinner.getSelectedItem().toString();

        FGdatabase goal = new FGdatabase(d, dd, ddd, "");
        goal.save();

    }

    public void addDream() {
        String d = addVist.getText().toString();
        String dd = addDtail.getText().toString();
        FDdatabase dream = new FDdatabase(d, dd, "e");
        dream.save();


    }

    public void addRole() {
        String d = addVist.getText().toString();
        FRdatabase role = new FRdatabase(d, "e");
        role.save();

    }

    public void addSpineritem() {
        models = FRdatabase.listAll(FRdatabase.class);
        for (int i = 0; i < models.size(); i++) {
            list.add(models.get(i).getName());
        }

    }


}