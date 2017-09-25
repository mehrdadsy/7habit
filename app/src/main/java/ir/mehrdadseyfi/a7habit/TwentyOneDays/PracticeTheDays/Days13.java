package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days13);
        TextView txt=(TextView)findViewById(R.id.slide45);
        txt.setText("بعد از خود آگاهی،" +
                " قوۀ تخیل و وجدان، چهارمین موهبت منحصر به فرد انسان نیروی اراده مستقل است که راه را برای احراز مقام شامخ مدیریت مؤثر نفس هموار می کند: توانایی تصمیم گیری درست و عمل به آن؛ توانایی تأثیرگذاری به جای تأثیر پذیری و اجرای عاملانه برنامه ای که تا کنون به وسیله سه موهبت دیگر بسط و توسعه داده ایم.\n");
    }
}
