package comfirebasestudentapp.example.a15056158.medicinereminder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056158 on 5/8/2017.
 */

public class medicationAdapter extends ArrayAdapter<medication> {
    Context context;
    int layoutResourceId;
    ArrayList<medication> medicationList = null;


    public medicationAdapter(Context context, int resource, ArrayList<medication> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.medicationList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        medicationHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new medicationHolder();
            holder.medName = (TextView)row.findViewById(R.id.txtmedName);
            holder.medDosage= (TextView)row.findViewById(R.id.txtmedDosage);
            holder.medTime= (TextView)row.findViewById(R.id.txtmedTime);
            holder.medDate= (TextView)row.findViewById(R.id.txtmedDate);
            holder.medRemarks= (TextView)row.findViewById(R.id.txtRemarks);


            row.setTag(holder);
        }
        else
        {
            holder = (medicationHolder)row.getTag();
        }

        medication medication = medicationList.get(position);
        holder.medName.setText("Name: " + medication.getmed_name());
        holder.medDosage.setText("Dosage: " + medication.getmed_dosage());
        holder.medTime.setText("Time: " + medication.getmed_time());
        holder.medDate.setText("Date: " + medication.getMed_date());
        holder.medRemarks.setText("Remarks: " + medication.getremarks());

        return row;
    }

    static class medicationHolder
    {
        TextView medName;
        TextView medDosage;
        TextView medTime;
        TextView medDate;
        TextView medRemarks;

    }


}
