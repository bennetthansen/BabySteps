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
            holder.checklistDate = (TextView)row.findViewById(R.id.checklistDate);
            holder.checklistName = (TextView)row.findViewById(R.id.checklistName);
            holder.checklistProgress = (TextView)row.findViewById(R.id.checklistProgress);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ChecklistHolder)row.getTag();
        }
        
        Checklist checklist = data[position];
        holder.checklistName.setText(checklist.title);
        holder.checklistDate.setText(checklist.date);
        holder.checklistProgress.setText(checklist.progress);
        
        return row;
    }
    
    static class ChecklistHolder
    {
        TextView checklistDate;
        TextView checklistName;
        TextView checklistProgress;
    }
}
