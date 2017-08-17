package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mehrdad on 8/16/2017.
 */

public class LongGoalAdapter extends BaseAdapter {
    String name[];
    String Date[];
    Context mContext;
    int catPhoto[];


    public LongGoalAdapter(String[] name, Context mContext, int catPhoto[], String Date[]) {
        this.name = name;
        this.mContext = mContext;
        this.catPhoto = catPhoto;
        this.Date = Date;
    }

    @Override
    public int getCount() {
        return name.length;
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




            txt.setText(name[position]);
            date.setText(Date[position]);

            img.setImageResource(catPhoto[position]);
            return rowView;



    }
}
