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

        TextView quantityView = (TextView) findViewById(R.id.quantity_text_view);
        quantityView.setText("0");
    }

    /**
     * This method is called when the order button is clicked.
     *
     * @param view is not used here
     */
    public void submitOrder(@SuppressWarnings("UnusedParameters") View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    /**
     * Calculates the price of the order.
     *
     * @return returns the price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Creates the order summary for an order
     *
     * @param price is the price of the current order
     * @return returns a string with the order summary
     */
    private String createOrderSummary(int price) {
        String priceString = NumberFormat.getCurrencyInstance().format(price);
        String orderSummaryString = "Name: Jens";
        orderSummaryString += "\nQuantity: " + quantity;
        orderSummaryString += "\nTotal: " + priceString;
        orderSummaryString += "\nThank you!";
        return orderSummaryString;
    }

    /**
     * This method displays the given quantity value on the screen.
     *
     * @param count is the number of ordered coffees
     */
    private void displayQuantity(int count) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(count));
    }

    /**
     * This method displays the given text on the screen.
     *
     * @param message is the message which should be shown on the screen
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method increases the variable "quantity" by 1
     *
     * @param view is not used here
     */
    public void increment(@SuppressWarnings("UnusedParameters") View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     *
     * This method decreases the variable "quantity" by 1
     *
     * @param view is not used here
     */
    public void decrement(@SuppressWarnings("UnusedParameters") View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
