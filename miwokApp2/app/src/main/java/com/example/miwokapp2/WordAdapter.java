package com.example.miwokapp2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<word> {
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<word> num,int colorResourceId) {

        super(context, 0, num);
        mColorResourceId=colorResourceId;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }


        word currentWord = getItem(position);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokText);

        miwokTextView.setText(currentWord.getMiwokTranslation());


        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.defaultText);

        DefaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {


            miwokImageView.setImageResource(currentWord.getResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        else
        {
            miwokImageView.setVisibility(View.GONE);

        }
        View textContainew=listItemView.findViewById(R.id.textContainer);
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        textContainew.setBackgroundColor(color);

        return listItemView;
    }
}
