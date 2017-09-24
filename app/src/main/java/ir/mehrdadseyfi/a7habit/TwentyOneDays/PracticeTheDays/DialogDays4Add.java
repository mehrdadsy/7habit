package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import ir.mehrdadseyfi.a7habit.R;

public class DialogDays4Add extends AppCompatActivity {
    EditText negraniTl;
    EditText negraniDl;
    Button save;
    Button cancel;
    Days3DB days3DB;
    RadioButton in;
    RadioButton out;
    int inOut;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_days4_add);
        negraniDl = (EditText) findViewById(R.id.negrani_tl);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(negraniDl.getText()).matches("")) {
                    Toast.makeText(DialogDays4Add.this, "نگرانی خود را وارد کنید", Toast.LENGTH_SHORT).show();
                } else {
                    addNegarani();
                    finish();
                }
            }
        });

    }

    public void addNegarani() {

        Days3DB book = Days3DB.findById(Days3DB.class, id);
        book.detial=String.valueOf(negraniDl.getText());
        book.save();
    }
}
