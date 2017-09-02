package ir.mehrdadseyfi.a7habit.Calender;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by Mehrdad on 8/30/2017.
 */

public class ShowJobDayListAdapter extends BaseAdapter {
    List<JobDB> models;
    Context mContext;

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    public ShowJobDayListAdapter(List<JobDB> models, Context mContext) {
        this.models = models;
        this.mContext = mContext;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.show_job_day, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.tilte);
        TextView detail = (TextView) rowView.findViewById(R.id.detial);
        TextView goal = (TextView) rowView.findViewById(R.id.goal);
        TextView startdate = (TextView) rowView.findViewById(R.id.start_date);
        TextView enddate = (TextView) rowView.findViewById(R.id.end_date);
        title.setText(models.get(position).getName());
        detail.setText(models.get(position).getDetail());
        goal.setText("مربوط به هدف:"+" "+models.get(position).getGoal());
        String startDate=models.get(position).getyear()+"/"+models.get(position).getmount()+"/"+models.get(position).getday()+"   "+models.get(position).getshours()+":"+models.get(position).getsminutes();
        startdate.setText(startDate);
        String endDate=models.get(position).getehours()+":"+models.get(position).geteminutes();
        enddate.setText(endDate);

        return rowView;
    }
}
