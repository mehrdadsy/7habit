package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/18/2017.
 */

public class BadHabitAdapter extends BaseAdapter {
    List<BadHabitDB> models;
    Context mContext;

    public BadHabitAdapter(List<BadHabitDB> models, Context mContext) {
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.list_view_badhabit, parent, false);

        TextView tilte = (TextView) rowView.findViewById(R.id.list_tile_badHabit);

        TextView detial = (TextView) rowView.findViewById(R.id.list_detail_badHabit);
        TextView upgrade = (TextView) rowView.findViewById(R.id.list_upgrade_badHabit);


        tilte.setText(models.get(position).getHabitTitle());
        detial.setText(models.get(position).getHabitdetails());
        upgrade.setText(models.get(position).getUpgradeHabit());

        return rowView;
    }
}
