package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChildListAdapter extends ArrayAdapter<ChildList>{

    Context context; 
    int layoutResourceId;    
    ChildList data[] = null;
    
    public ChildListAdapter(Context context, int layoutResourceId, ChildList[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ChildListHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ChildListHolder();
            holder.childName = (TextView)row.findViewById(R.id.childName);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ChildListHolder)row.getTag();
        }
        
        ChildList ChildList = data[position];
        holder.childName.setText(ChildList.childName);
        
        return row;
    }
    
    static class ChildListHolder
    {
        TextView childName;
    }
}
