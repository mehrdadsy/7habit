package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days15);
        TextView txt=(TextView)findViewById(R.id.slide50);
        txt.setText("به تعبیر پیتر دراکر، افراد مؤثر هرگز مسایل را مرکز توجه قرار نمی دهند بلکه ذهن را به فرصتها و راه حلها معطوف می دارند." +
                " در حقیقت آنان به فرصتها خوراک می رسانند و مسائل را دچار گرسنگی می کنند؛ قاطعانه می اندیشند؛ به ضرورتها و بحرانها مربع 1 بی توجهند و با تمرکز به مارهای ضروری و غیرو فوریتی مربع 2 اهرم نیرومندی را در اختیار گرفته، بین تولید و قابلیت تولید تعادل برقرار می کنند.\n");
        TextView txt1=(TextView)findViewById(R.id.slide52_1);
        TextView txt2=(TextView)findViewById(R.id.slide52_2);
        txt1.setText("ابزار مربع 2 : هدف آن نیست که اجزای برنامۀ خود را اولیت بندی کنید، مقصود آن است که اولویتهای کار و زندگیتان را به نظم درآورید.");
        txt2.setText("هدف مدیریت مربع 2، ادارۀ زندگی ما به گونه ای مؤثر است." +
                " برای دستیابی به این مقصود، اصول درست و منطقی و رسالت فردی کانون توجه قرار می گیرد به ضرورت هر کار به اندازۀ فوریت آن بها داده می شود و همه اینها در چارچوب حفظ توازن بین افزایش تولید و افزایش توانایی تولیدما، ارزیابی می شود.\n");
    }
}
