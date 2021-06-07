package com.example.prac55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void increment (View view)
    {
        if(quantity<100)
        quantity=quantity+1;
        else
            Toast.makeText(this,"You cannot have more than 100 coffee",Toast.LENGTH_SHORT).show();
        display(quantity);

    }public void decrement (View view)
    {
        if(quantity>1)
        quantity=quantity-1;
        else
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
        display(quantity);

    }
    public void submitOrder(View view){

        CheckBox c=(CheckBox)findViewById(R.id.whipped_cream);
        boolean w=c.isChecked();

        CheckBox d=(CheckBox)findViewById(R.id.chocolate);
        boolean choc=d.isChecked();
        String priceMessage;
        int price=calculatePrice(quantity,w,choc);
        EditText e=(EditText)findViewById(R.id.person_name);
       String name=e.getText().toString();


        priceMessage=  createOrderSummary(price,w,choc,name);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this

            intent.putExtra(Intent.EXTRA_SUBJECT, "just java Order for "+name);
            intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);

        }
        displayMessage(priceMessage);




    }
    public void resetvalues(View view)
    {
        quantity=0;
        display(quantity);
        CheckBox c=(CheckBox)findViewById(R.id.whipped_cream);
        c.setChecked(false);
        CheckBox d=(CheckBox)findViewById(R.id.chocolate);
        d.setChecked(false);

        EditText t=(EditText)findViewById(R.id.person_name);
        t.setText("");


        displayMessage("0");
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.summary_text_view);
        orderSummaryTextView.setText(message);

    }
    private int calculatePrice(int quantity,boolean w,boolean c)
    {
        int basePrice=5;
        int price =0;
        if(w&&c)

            price=(1+2+basePrice)*quantity;

        else if(w&& c==false)
            price=(1+basePrice)*quantity;
        else if(w==false && c==true )
            price=(2+basePrice)*quantity;
        else
            price=quantity*basePrice;
        return price;

    }
    private String createOrderSummary(int price,boolean w,boolean choc,String e)
    {
        return "Name: "+e+
                "\n"+getString(R.string.add_cream)+w+"" +
                "\n"+getString(R.string.add_choc)+choc+"" +
                "\n"+getString(R.string.quantity)+quantity+"" +
                "\n"+getString(R.string.total)+price+
                "\n"+getString(R.string.thank_you);
       

    }
}