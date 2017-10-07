package ir.mehrdadseyfi.a7habit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    TextView aboutUsTittleTextView, aboutUsDescriptionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        aboutUsTittleTextView = (TextView) findViewById(R.id.about_us_tittle);

        aboutUsDescriptionTextView = (TextView) findViewById(R.id.about_us_description);
    }
}
