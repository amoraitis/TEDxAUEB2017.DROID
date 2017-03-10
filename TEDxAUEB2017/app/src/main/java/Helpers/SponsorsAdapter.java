package Helpers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

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
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        GlideDrawableImageViewTarget sponsorViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this.mContext).load(spoDataSet.get(position).getImage()).into(sponsorViewTarget);
        return imageView;
    }

}