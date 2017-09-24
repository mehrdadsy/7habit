package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days6);
        TextView txt=(TextView)findViewById(R.id.slide23);
        txt.setText("ذهناً مجسم کنید که به مراسم خاک سپاری خود می روید.\n" +
                "در آن مراسم در مورد شما چه می گویند؟؟؟\n" +
                "مفهوم ((ذهناً از پایان آغاز کنید)) چیست؟\n" +
                "اگر به طور جدی تجربه بالا را مجسم کرده باشید، لحظه یی با ژرفترین و بنیادی ترین ارزشهای خود تماس یافته اید. در دل ((حلقه نفوذتان)) تماس کوتاهی با نظام هدایت درونی خود برقرار کرده اید.\n" +
                "((ذهناً از پایان آغاز کنید)) یعنی اینکه به روشنی مقصدتان را بشناسید. یعنی بدانید به کجا می روید، تا بتوانید بهتر دریابید که اکنون کجا هستید و گامهایی را که بر می دارید همواره در مسیر درست است.\n");
    }
}
