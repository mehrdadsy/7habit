package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.Vista.FDdatabase;

/**
 * Created by admin on 8/26/2017.
 */

public class Days3Adapter extends BaseAdapter {
   List<Days3DB>models;
    Context mContext;

    public Days3Adapter(List<Days3DB> models, Context mContext) {
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
        dreamDetail.setText("راه کار عاملانه"+" : "+models.get(position).getDetial());
        ImageView dream_img = (ImageView) rowView.findViewById(R.id.dream_img_d);
    int i=Integer.parseInt(models.get(position).gethalghe());
        if (i==1) {
            dream_img.setImageResource(R.drawable.dream);
        }else {
            dream_img.setImageResource(R.drawable.goal);

        }
            return rowView;
    }
}
