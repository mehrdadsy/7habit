package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days8);
        TextView txt1=(TextView)findViewById(R.id.slide26_1);
        TextView txt=(TextView)findViewById(R.id.slide26_2);
        txt.setText("عادت 2 مبتنی بر اصول رهبری خویشتن است. به این معنا که رهبری، نخستین آفرینش است. رهبری، مدیریت نیست. مدیریت، دومین آفرینش است که در فصل مربوط به  ((عادت3)) درباره اش گفتگو خواهیم کرد. اما نخست رهبری باید بیاید.\n" +
                "مدیریت یعنی درست انجام دادن امور، رهبری انجام دادن امور درست.\n" +
                " مدیریت یعنی کارآیی در صعود نردبان ترقی؛ حال آنکه رهبری یعنی تشخیص این که آیا نردبان به دیوار درست تکیه دارد یا نه!\n");
        txt1.setText("همانگونه که پیش از این ملاحظه کردیم،" +"\n"+
                " عامل بودن مبتنی بر موهبت یکتا و انسانی خودآگاهی است. دو موهبت یکتای انسانی دیگر که مارا قادر به گسترش عامل بودن خود می سازند و اجازه می دهند که رهبری را در زندگی شخصی خود به کار گیریم عبارتند از تخیل و وجدان");
        //////// az roya dirouz por mishavad
        TextView txt3=(TextView)findViewById(R.id.dream_sozan);

    }
}
