package ir.mehrdadseyfi.a7habit.Emegency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/21/2017.
 */

public class EmergencyEssntialListAdapter extends BaseAdapter {
   List<EmergencyEssntialItem> models;
    Context mContext;

    public EmergencyEssntialListAdapter(List<EmergencyEssntialItem> models, Context mContext) {
        this.models = models;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.emergency_essntial_list_view, parent, false);
        TextView txt=(TextView)rowView.findViewById(R.id.tilte);
        txt.setText(models.get(position).getTitle());
        TextView detail=(TextView)rowView.findViewById(R.id.detial);
        detail.setText(models.get(position).getDetial());
        String date=models.get(position).getCalenderYear()+"/"+models.get(position).getCalenderMount()+"/"+models.get(position).getCalenderday();
       TextView date_persin=(TextView)rowView.findViewById(R.id.caleder);
        date_persin.setText(date);
        String clock=models.get(position).getHours()+" : "+models.get(position).getMinutes();
        TextView clock_persin=(TextView)rowView.findViewById(R.id.clock);
        clock_persin.setText(clock);
        return rowView;
    }
}
