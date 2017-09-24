package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.R;

public class Days7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days7);
        TextView txt=(TextView)findViewById(R.id.slide25);
        txt.setText("قاعده نجاری می گوید: (( دو بار اندازه بگیر و یک بار ببر.))\n" +
                "باید مطمئن شوید که نقشه کار- نخستین آفرینش- واقعاً همان است که می خواهید، و همه جزییات آن را اندیشیده اید. آنگاه آن را به صورت آجر و شفته در می آورید. هر روز به سر ساختمان می روید و به نقشه نگاه می کنید تا به برنامه و کار آن روز پی ببرید. ذهناً از پایان آغاز می کنید. \n");
    }
}
