package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mehrdadseyfi.a7habit.Esstinal.Noemergency.NoEmergencyEssntialActivity;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.SquareTasksActivity;

public class Days14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days14);
        TextView txt=(TextView)findViewById(R.id.slide48);
        txt.setText("پیروزمندان به انجام کارهایی خو کرده اند که با زندگان از انجامش می گریزند و هرگز به آن تن در نمی دهند." +
                " حتی اگر پیروزمندان مایل به انجام کاری نباشند، این بی میلی از عزم و ارادۀ مستقل ایشان ناشی می شود.\n");
        findViewById(R.id.goToSquare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Days14.this, SquareTasksActivity.class));

            }
        });
    }
}
