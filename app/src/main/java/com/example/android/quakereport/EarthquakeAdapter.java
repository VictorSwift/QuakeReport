package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by VICTOR on 7/19/2018.
 */

class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    /*Return a list item view that displays information about the earthquake at the given position in the list of
    * earthquakes*/
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise if null, inflate the new list view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        /*find the earthquake at the given position in the list of earthquake*/
        Earthquake currentEarthquake = getItem(position);

        /*find the TextView with the view ID "magnitude"*/
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude((currentEarthquake.getMagnitude()));

        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);

        /*find the TextView with the view ID "location"*/
        TextView locationView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView locationView2 = (TextView) listItemView.findViewById(R.id.primary_location);

        //get the location string
        String location_string = currentEarthquake.getLocation();

        if (location_string.contains("of")){
            //split the string into two parts using he delimiter
            String[] parts = location_string.split("(?<=of)"); //using "of" as the delimiter and still retain the of
            String part1 = parts[0];
            String part2 = parts[1].trim(); //trim() helps remove the leading space
            //Display the location of the current earthquake
            locationView.setText(part1);
            locationView2.setText(part2);
        }
        else{
            locationView2.setText(location_string);
        }

        /*find the TextView with the view ID "date"*/
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);

        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //return the list view that is showing the appropriate data
        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    /**
     * Return the right background color corresponding to the earthquake magnitude
     *
     */
    private int getMagnitudeColor(Double magnitude) {
        int magnitudeColor;
        switch (magnitude.toString()){
            case "0.0": case "2.0":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case "2.1": case "2.2": case "2.3": case "2.4": case "2.5": case "2.6": case"2.7": case "2.8": case "2.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case "3.1": case "3.2": case "3.3": case "3.4": case "3.5": case "3.6": case"3.7": case "3.8": case "3.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case "4.1": case "4.2": case "4.3": case "4.4": case "4.5": case "4.6": case"4.7": case "4.8": case "4.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case "5.1": case "5.2": case "5.3": case "5.4": case "5.5": case "5.6": case"5.7": case "5.8": case "5.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case "6.1": case "6.2": case "6.3": case "6.4": case "6.5": case "6.6": case"6.7": case "6.8": case "6.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case "7.1": case "7.2": case "7.3": case "7.4": case "7.5": case "7.6": case"7.7": case "7.8": case "7.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case "8.1": case "8.2": case "8.3": case "8.4": case "8.5": case "8.6": case"8.7": case "8.8": case "8.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case "9.1": case "9.2": case "9.3": case "9.4": case "9.5": case "9.6": case"9.7": case "9.8": case "9.9":
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }

}
