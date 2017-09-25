package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days9);
        TextView txt=(TextView)findViewById(R.id.slide30);
        txt.setText("هنگامی که درون حلقه نفوذمان به کار سرگرمیم، آن را گسترش می بخشیم." +
                " این بالاترین اهرم برای افزایش قابلیت تولید است، و به طرزی قابل ملاحظه بر همه جنبه های زندگیمان تأثیر می گذارد.\n");
    }
}
