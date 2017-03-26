package com.greiner_co.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // private properties
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(@SuppressWarnings("UnusedParameters") View view) {
        int price = quantity * 5;
        String priceString = NumberFormat.getCurrencyInstance().format(price);
        String priceMessage = "Total: " + priceString + "\nThank you!";
        displayMessage(priceMessage);
        //displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method increases the variable "quantity" by 1
     */
    public void increment(@SuppressWarnings("UnusedParameters") View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     *
     * This method decreases the variable "quantity" by 1
     */
    public void decrement(@SuppressWarnings("UnusedParameters") View view) {
        quantity = quantity - 1;
        display(quantity);
    }
}
