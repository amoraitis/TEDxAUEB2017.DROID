package Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tedxaueb.tedxaueb2017.R;

import java.util.ArrayList;
import java.util.List;

import Models.Speaker;

/**
 * Created by tasos on 2/27/2017.
 */

public class SpeakersListAdapter extends BaseAdapter {
    private List<Speaker> speakerArrayList;
    private LayoutInflater layoutInflater;

    public SpeakersListAdapter(Context aContext, List<Speaker> speakerArrayList){
        this.speakerArrayList = speakerArrayList;
        layoutInflater= LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return speakerArrayList.size();
    }

    @Override
    public Object getItem(int position){
        return speakerArrayList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.splistitemrow,null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.Title);
            holder.ImageView = (ImageView) convertView.findViewById(R.id.Thumbnail);
            holder.subTitleView=(TextView)convertView.findViewById(R.id.Description);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.headlineView.setText(speakerArrayList.get(position).getName());
        holder.subTitleView.setText(speakerArrayList.get(position).getShortBio());

        return convertView;
    }

    static class ViewHolder {
        TextView headlineView;
        TextView subTitleView;
        ImageView ImageView;
    }
}
