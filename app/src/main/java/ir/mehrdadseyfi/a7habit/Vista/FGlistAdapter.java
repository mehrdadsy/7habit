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

public class FGlistAdapter extends BaseAdapter {
   List<FGdatabase>models;
    Context mContext;

    public FGlistAdapter(List<FGdatabase> models, Context mContext) {
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.fg_list_layout, parent, false);
        TextView dearmTitle=(TextView)rowView.findViewById(R.id.tilte);
        dearmTitle.setText(models.get(position).getName());
        TextView dreamDetail=(TextView)rowView.findViewById(R.id.detial);
        TextView roleGoal=(TextView)rowView.findViewById(R.id.goal_role);
        dreamDetail.setText(models.get(position).getDetial());
        roleGoal.setText("مربوط به نقش:"+" "+models.get(position).getRole());
        ImageView dream_img=(ImageView)rowView.findViewById(R.id.dream_img);
        dream_img.setImageResource(R.drawable.ic_launcher);
        return rowView;
    }
}
