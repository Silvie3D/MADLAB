package com.example.project_3;

// Import Android classes
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables for input boxes
    private EditText numInput1, numInput2;

    // Variable for displaying result
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Start the Activity
        super.onCreate(savedInstanceState);

        // Connect Java with activity_main.xml
        setContentView(R.layout.activity_main);

        // Connect first EditText from XML
        numInput1 = findViewById(R.id.firstnum);

        // Connect second EditText from XML
        numInput2 = findViewById(R.id.secondnum);

        // Connect result TextView from XML
        resultText = findViewById(R.id.resulttext);

        // Find Add button
        Button btnAdd = findViewById(R.id.btnAdd);

        // When Add button is clicked
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform addition
                performCalculation('+');
            }
        });

        // Find Subtract button
        Button btnSubtract = findViewById(R.id.btnSubtract);

        // When Subtract button is clicked
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform subtraction
                performCalculation('-');
            }
        });

        // Find Multiply button
        Button btnMultiply = findViewById(R.id.btnProduct);

        // When Multiply button is clicked
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform multiplication
                performCalculation('*');
            }
        });

        // Find Divide button
        Button btnDivide = findViewById(R.id.btnDivide);

        // When Divide button is clicked
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform division
                performCalculation('/');
            }
        });
    }

    // Method for performing calculation
    // operation receives +, -, * or /
    private void performCalculation(char operation) {

        // Get first number from EditText
        String input1 = numInput1.getText().toString();

        // Get second number from EditText
        String input2 = numInput2.getText().toString();

        // Convert first input from String to double
        double num1 = Double.parseDouble(input1);

        // Convert second input from String to double
        double num2 = Double.parseDouble(input2);

        // Variable to store answer
        double result = 0;

        // Check which operation was selected
        switch (operation) {

            // Addition
            case '+':
                result = num1 + num2;
                break;

            // Subtraction
            case '-':
                result = num1 - num2;
                break;

            // Multiplication
            case '*':
                result = num1 * num2;
                break;

            // Division
            case '/':
                // Check division by zero
                if (num2 == 0) {
                    resultText.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
                break;

            // If operation is not +, -, * or /
            default:
                resultText.setText("Invalid operation");
                return;
        }

        // Display the result
        resultText.setText("Result: " + result);
    }
}