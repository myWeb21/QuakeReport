package com.example.myprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        EditText name = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText pass = (EditText) findViewById(R.id.editTextNumberPassword);
        String u = name.getText().toString();
        String p = pass.getText().toString();

        if (!u.equalsIgnoreCase("Hariom") && !p.equals("hariom11")) {

            Toast.makeText(this, getString(R.string.userAndPassInc), Toast.LENGTH_SHORT).show();
        } else if (!p.equals("hariom11"))
            Toast.makeText(this, getString(R.string.passInc), Toast.LENGTH_SHORT).show();
        else if (!u.equalsIgnoreCase("Hariom"))
            Toast.makeText(this, getString(R.string.userInc), Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, getString(R.string.matched), Toast.LENGTH_SHORT).show();
            final int REQUEST_IMAGE_CAPTURE = 1;
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            } catch (ActivityNotFoundException e) {
                // display error state to the user
            }
        }
    }




    }
