package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayOrderDetails extends AppCompatActivity {
    String name;
    String message;
    String strTotalPrice;
    CoffeeDBHandler dbHandler = new CoffeeDBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_details);
        //create an intent to catch the String and display
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        message = intent.getStringExtra("message");
        strTotalPrice = intent.getStringExtra("saleAmount");
        //getting the final output ready
        String output = "Name: "+name +"\n"+ message;
        //create an object of the TextView to display
        TextView displayTextView = (TextView) findViewById(R.id.displayText);
        //display the final output
        displayTextView.setText(output);


    }
    // a method that will open GMail
    public void openEmail (View view){
        // Use an intent (Common) to launch an email app.
        // Send the order summary in the email body.
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Coffee order for "+name);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }

    public void addButtonClicked(View view) {
        order order = new order(Integer.parseInt(strTotalPrice));
        dbHandler.addOrder (order);
        Toast.makeText(getApplicationContext(),"Data Save!", Toast.LENGTH_SHORT). show();



    }

    public void salesReport(View view) {
        String dbString = dbHandler.databaseToString();
        Intent salesIntent = new Intent ( this, DisplaySalesDetails.class);
        salesIntent.putExtra( "db", dbString);
        startActivity(salesIntent);




    }


}
