package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days3_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days3_4);
        TextView txt=(TextView)findViewById(R.id.slide12);
        txt.setText("واکنش من چیه؟\n" +
                "من چه خواهم کرد؟\n" +
                "من چگونه می توانم درایت وضعیف ابتکار عمل را به دست بگیرم؟\n");
        TextView txt1=(TextView)findViewById(R.id.slide15);
        txt1.setText("توجه عامل"+"\n"+"( انرژی مثبت، حلقه نفوذ را وسعت می بخشد)");
    }
}
