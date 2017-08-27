package ir.mehrdadseyfi.a7habit.Vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/26/2017.
 */

public class FRlistAdapter extends BaseAdapter {
   List<FRdatabase>models;
    Context mContext;

    public FRlistAdapter(List<FRdatabase> models, Context mContext) {
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.fr_list_layout, parent, false);
        TextView roleTitle=(TextView)rowView.findViewById(R.id.tilte);
         roleTitle.setText(models.get(position).getName());
        ImageView dream_img=(ImageView)rowView.findViewById(R.id.dream_img);
        dream_img.setImageResource(R.drawable.ic_launcher);
        return rowView;
    }
}
