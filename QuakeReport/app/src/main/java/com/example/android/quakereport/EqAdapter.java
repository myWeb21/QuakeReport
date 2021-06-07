package com.example.android.quakereport;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class EqAdapter extends ArrayAdapter<Earthquake> {
    private Context mContext;
    private static final String LOCATION_SEPARATOR=" of ";



    public EqAdapter(@NonNull Context context, ArrayList<Earthquake> li) {
        super(context, 0, li);
        mContext = context;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.view, parent, false);

        Earthquake currentEarthQuake = getItem(position);

        TextView mag = (TextView) listItem.findViewById(R.id.magnitude);
        double magni=currentEarthQuake.getmag();
        DecimalFormat format =new DecimalFormat(("0.0"));
        String magnitudeOutput=format.format(magni);
        mag.setText(magnitudeOutput);
        GradientDrawable magnitudeCircle=(GradientDrawable) mag.getBackground();

        int magnitudeColor=getMagnitudeColor(currentEarthQuake.getmag());
        magnitudeCircle.setColor(magnitudeColor);



        String originalLocation=currentEarthQuake.getplace();

        String primaryLocation,locationOffSet;

        if(originalLocation.contains(LOCATION_SEPARATOR))
        {
            String parts[]=originalLocation.split(LOCATION_SEPARATOR);
            locationOffSet=parts[0]+LOCATION_SEPARATOR;
            primaryLocation=parts[1];
        }
        else
        {
            locationOffSet=getContext().getString(R.string.near_the);
            primaryLocation=originalLocation;

        }



        TextView primaryLocationView = (TextView) listItem.findViewById(R.id.location_primary);
        primaryLocationView.setText(primaryLocation);
        TextView offsetLocationView= (TextView) listItem.findViewById(R.id.location_offset);
        offsetLocationView.setText(locationOffSet);


        TextView date = (TextView) listItem.findViewById(R.id.date);
        long time=currentEarthQuake.getd();
        Date d=new Date(time);
        SimpleDateFormat dateFormat=new SimpleDateFormat("LLL DD, YYYY");
        String dateToDisplay=dateFormat.format(d);
        date.setText(dateToDisplay);

        TextView currtime=(TextView)listItem.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String t=timeFormat.format(d);
        currtime.setText(t);

        return listItem;
    }
    private int getMagnitudeColor(double magnitude)
    {
        int magnitudeColorResourceId;
        int magnitudeFloor=(int)Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }
}
