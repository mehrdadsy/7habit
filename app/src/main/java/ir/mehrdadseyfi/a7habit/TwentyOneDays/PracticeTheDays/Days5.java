package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days5);
        TextView txt=(TextView)findViewById(R.id.slide19);
        txt.setText("گاه عامل ترین کاری که می توانیم بکنیم شاد بودن، است:" +
                " فقط لبخندی راستین. خوشبختی انتخابی عامل است.\n");
        TextView txt1=(TextView)findViewById(R.id.slide20);
        txt1.setText("در دل ((حلقه نفوذمان)) توانایی ایجاد تعهد و حفظ تعهد و وفا کردن به عهدهایمان.))" +
                " خودمان و دیگران – نهفته است. به انجام رساندن آن تعهدات و پیمانها، جوهر و روشنترین تجلی عامل بودن ماست.\n");
        TextView txt2=(TextView)findViewById(R.id.slide20);
        txt2.setText("قدرت با خود عهد بستن و بر سر این عهد ایستادن،" +
                " جوهر پرورش عادتهای بنیادی کارآیی است.\n");
    }
}
