package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PackingListAdapter extends ArrayAdapter<PackingList>{

    Context context; 
    int layoutResourceId;    
    PackingList data[] = null;
    
    public PackingListAdapter(Context context, int layoutResourceId, PackingList[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PackingListHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new PackingListHolder();
            holder.listDate = (TextView)row.findViewById(R.id.listDate);
            holder.listName = (TextView)row.findViewById(R.id.listName);
            holder.listProgress = (TextView)row.findViewById(R.id.listProgress);
            
            row.setTag(holder);
        }
        else
        {
            holder = (PackingListHolder)row.getTag();
        }
        
        PackingList packingList = data[position];
        holder.listName.setText(packingList.title);
        holder.listDate.setText(packingList.date);
        holder.listProgress.setText(packingList.progress);
        
        return row;
    }
    
    static class PackingListHolder
    {
        TextView listDate;
        TextView listName;
        TextView listProgress;
    }
}
