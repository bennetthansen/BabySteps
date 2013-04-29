package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChecklistAdapter extends ArrayAdapter<Checklist>{

    Context context; 
    int layoutResourceId;    
    Checklist data[] = null;
    
    public ChecklistAdapter(Context context, int layoutResourceId, Checklist[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ChecklistHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ChecklistHolder();
            holder.checklistItemName = (TextView)row.findViewById(R.id.checklistItemName);
            holder.checklistItemQuantity = (TextView)row.findViewById(R.id.checklistItemQuantity);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ChecklistHolder)row.getTag();
        }
        
        Checklist checklist = data[position];
        holder.checklistItemName.setText(checklist.itemName);
        holder.checklistItemQuantity.setText(checklist.itemQuantity);
        
        return row;
    }
    
    static class ChecklistHolder
    {
        TextView checklistItemName;
        TextView checklistItemQuantity;
    }
}
