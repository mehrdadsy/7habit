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

public class FDlistAdapter extends BaseAdapter {
   List<FDdatabase>models;
    Context mContext;

    public FDlistAdapter(List<FDdatabase> models, Context mContext) {
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.fd_list_layout, parent, false);
        TextView dearmTitle=(TextView)rowView.findViewById(R.id.tilte_d);
        dearmTitle.setText(models.get(position).getName());
        TextView dreamDetail=(TextView)rowView.findViewById(R.id.detial_d);
        dreamDetail.setText(models.get(position).getDetial());
        ImageView dream_img=(ImageView)rowView.findViewById(R.id.dream_img_d);
        dream_img.setImageResource(R.drawable.dream);
        return rowView;
    }
}
