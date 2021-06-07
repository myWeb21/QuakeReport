package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, ArrayList<Word> a) {
        super(context, 0, a);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);

        }
        Word currentWord =getItem(position);

        TextView engtextView=(TextView) listItemView.findViewById(R.id.eng);
        engtextView.setText(currentWord.getEnglish());

        TextView hinTextView=(TextView)listItemView.findViewById(R.id.hin);
        hinTextView.setText(currentWord.getHindi());

        ImageView image=(ImageView)listItemView.findViewById(R.id.image1);
        image.setImageResource(currentWord.getImage());
        return  listItemView;



    }
}
