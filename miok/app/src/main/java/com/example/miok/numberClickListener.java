package com.example.miok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class numberClickListener  extends  android.app.Activity implements View.OnClickListener{


    @Override
    public void onClick(View view)
    {
        Toast.makeText(view.getContext(),"open the numbers list", Toast.LENGTH_SHORT).show();
    }

}
