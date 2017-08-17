package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/17/2017.
 */

public class LongGoalSugarAdapter extends BaseAdapter {
    List<GoalSugarDB>models;
    Context mContext;

    public LongGoalSugarAdapter(List<GoalSugarDB> models, Context mContext) {
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.list_view_goal, parent, false);

        TextView txt = (TextView) rowView.findViewById(R.id.txt);

        TextView date = (TextView) rowView.findViewById(R.id.date);
        ImageView img = (ImageView) rowView.findViewById(R.id.cat_photo);




        txt.setText(models.get(position).getName());
        date.setText(models.get(position).getDate());

        img.setImageResource(R.mipmap.ic_launcher);
        return rowView;
    }
}
