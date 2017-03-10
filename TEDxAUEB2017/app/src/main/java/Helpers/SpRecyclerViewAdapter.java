package Helpers;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tedxaueb.tedxaueb2017.R;

import java.util.LinkedList;

import Models.Speaker;

/**
 * Created by tasos on 3/1/2017.
 */

public class SpRecyclerViewAdapter extends RecyclerView.Adapter<SpRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private LinkedList<Speaker> mDataset;
    private static MyClickListener myClickListener;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        TextView whatis;
        ImageView thumbnail;

        DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.Title);
            dateTime = (TextView) itemView.findViewById(R.id.Description);
            thumbnail=(ImageView)itemView.findViewById(R.id.Thumbnail);
            whatis = (TextView)itemView.findViewById(R.id.whatis);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        SpRecyclerViewAdapter.myClickListener = myClickListener;
    }

    public SpRecyclerViewAdapter(LinkedList<Speaker> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.splistitemrow, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getName());
        holder.dateTime.setText(mDataset.get(position).getShortBio());
        holder.whatis.setText(mDataset.get(position).getWhatis());
        holder.thumbnail.setImageResource(mDataset.get(position).getSmallImg());
    }

    public void addItem(Speaker dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
