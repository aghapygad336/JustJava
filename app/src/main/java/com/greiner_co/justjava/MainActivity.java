package com.greiner_co.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // private properties
    private int quantity = 0;
    private boolean hasWhippedCream = false;
    private boolean hasChocolate = false;

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
        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();
        displayMessage(createOrderSummary(price, name));
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
     * Sets either the Whipped Cream or Chocolate state
     *
     * @param view represents the calling CheckBox
     */
    public void setToppings(View view) {
        if (view != null) {
            CheckBox checkBox = (CheckBox) view;

            switch (checkBox.getId()) {
                case R.id.chocolate_checkbox:
                    hasChocolate = checkBox.isChecked();
                    break;
                case R.id.whipped_cream_checkbox:
                    hasWhippedCream = checkBox.isChecked();
                    break;
            }
        }
    }

    /**
     * Creates the order summary for an order
     *
     * @param price is the price of the current order
     * @param name is the name of the customer
     * @return returns a string with the order summary
     */
    private String createOrderSummary(int price, String name) {
        String priceString = NumberFormat.getCurrencyInstance().format(price);
        String orderSummaryString = "Name: " + name;
        orderSummaryString += "\nAdd whipped cream? " + hasWhippedCream;
        orderSummaryString += "\nAdd Chocolate? " + hasChocolate;
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
