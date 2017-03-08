package Helpers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.LinkedList;

import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class SponsorsAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<Sponsor> spoDataSet;

    public SponsorsAdapter(Context c) {
        mContext = c;
        spoDataSet=(new HandleSponsors()).getSponsors();
    }

    public int getCount() {
        return spoDataSet.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        try {
            imageView.setImageResource(spoDataSet.get(position).getImage());
        }catch (Exception e){

        }
            return imageView;
    }
}
