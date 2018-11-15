package com.example.dell.callpolice;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>implements View.OnClickListener {
    private List<Location> mLocation;
    private Context context;
    private OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener = null;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView location_Name;

        public ViewHolder(View v){
            super(v);
            location_Name=(TextView) itemView.findViewById(R.id.location_name);
        }
    }

    @Override
    public void onClick(View v) {
        mOnRecyclerviewItemClickListener.onItemClickListener(v, ((int) v.getTag()));
    }

    public LocationAdapter(List<Location> locationList, Context context,OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener){
        this.context=context;
        mLocation=locationList;
        this.mOnRecyclerviewItemClickListener=mOnRecyclerviewItemClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_location_layout,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Location lo=mLocation.get(i);
        viewHolder.location_Name.setText(lo.getName());
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mLocation.size();
    }
}
