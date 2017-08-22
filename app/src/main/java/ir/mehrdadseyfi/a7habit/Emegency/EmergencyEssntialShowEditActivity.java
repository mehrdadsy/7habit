package ir.mehrdadseyfi.a7habit.Emegency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class EmergencyEssntialShowEditActivity extends AppCompatActivity {
Long id;
    PieChart progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_essntial_show_edit);
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 1L);
        progressBar=(PieChart)findViewById(R.id.graph) ;
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(70f, "زمان سپری شده"));
        entries.add(new PieEntry(50.5f, "زمان مانده"));


        PieDataSet set = new PieDataSet(entries, "");
        PieData data = new PieData(set);
        set.setColors(new int[] { R.color.colorAccent, R.color.colorPrimary, }, EmergencyEssntialShowEditActivity.this);
            progressBar.getDescription().setEnabled(false);
        progressBar.setCenterText("70");
        Legend l = progressBar.getLegend();
        l.setEnabled(false);
        progressBar.setTouchEnabled(false);



        progressBar.setDrawEntryLabels(false);



        progressBar.setData(data);


        progressBar.invalidate(); // refresh









    }
}
