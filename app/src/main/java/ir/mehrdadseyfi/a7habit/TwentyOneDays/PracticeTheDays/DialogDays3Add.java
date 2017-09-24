package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ir.mehrdadseyfi.a7habit.R;

public class DialogDays3Add extends AppCompatActivity {
    EditText negraniTl;
    EditText negraniDl;
    Button save;
    Button cancel;
    Days3DB days3DB;
    RadioButton in;
    RadioButton out;
    int inOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_days3_add);

        negraniTl = (EditText) findViewById(R.id.negrani_tl);
       findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (String.valueOf(negraniTl.getText()).matches("")) {
                   Toast.makeText(DialogDays3Add.this, "نگرانی خود را وارد کنید", Toast.LENGTH_SHORT).show();
               } else {
                   addNegarani();
                   finish();
               }
           }
       });

    }

    public void addNegarani() {
        in=(RadioButton)findViewById(R.id.in);
        out=(RadioButton)findViewById(R.id.out);
        if(in.isChecked()){
            inOut=1;
        }else if (out.isChecked()){
            inOut=0;
        }

        days3DB = new Days3DB(String.valueOf(negraniTl.getText()), "", String.valueOf(inOut));
        days3DB.save();
    }
}
