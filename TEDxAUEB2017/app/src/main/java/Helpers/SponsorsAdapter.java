package Helpers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.LinkedList;

import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class SponsorsAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<Sponsor> spoDataSet;

    public SponsorsAdapter(Context c,LinkedList<Sponsor> spoDataSet) {
        mContext = c;
        this.spoDataSet=spoDataSet;
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
            imageView.setLayoutParams(new GridView.LayoutParams(140,140));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.with(this.mContext).load(Uri.parse(spoDataSet.get(position).getImage())).resize(140,140).centerInside()
                .into(imageView);
        return imageView;
    }

}
