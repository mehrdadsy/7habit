package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ir.mehrdadseyfi.a7habit.R;

public class EdirDreamActivity extends AppCompatActivity {
    long id;
    EditText editDream;
    EditText editDream_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edir_dream);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 1L);
        FDdatabase book1 = FDdatabase.findById(FDdatabase.class, id);
        editDream = (EditText) findViewById(R.id.edit_dream);
        editDream_d = (EditText) findViewById(R.id.edit_dream_d);
        editDream.setText(book1.getName());
        editDream_d.setText(book1.getDetial());
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FDdatabase book = FDdatabase.findById(FDdatabase.class, id);
                String name = editDream.getText().toString();
                String detail = editDream_d.getText().toString();
                book.setName(name);
                book.setDetial(detail);
                book.save();
                finish();
            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
