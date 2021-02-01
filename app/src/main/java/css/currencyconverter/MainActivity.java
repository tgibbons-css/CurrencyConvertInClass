package css.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextDollars;
    EditText editTextEuros;
    Button buttonConvertToDollars;
    Button buttonConvertToEuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDollars = findViewById(R.id.editTextDollars);
        editTextEuros = findViewById(R.id.editTextEuros);
        buttonConvertToDollars = findViewById(R.id.buttonConvertToDollars);
        buttonConvertToEuros = findViewById(R.id.buttonConvertToEuros);

        buttonConvertToEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dollarString = editTextDollars.getText().toString();
                Double dollars = Double.parseDouble(dollarString);    // DEBT : Should check if string is parsable first
                Double euros = dollars *0.83;                         // DEPT : Should read this from web service
                editTextEuros.setText(NumberFormat.getCurrencyInstance().format( euros ));
            }
        });

        buttonConvertToDollars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String euroString = editTextEuros.getText().toString();
                Double euros = Double.parseDouble(euroString);        // DEBT : Should check if string is parsable first
                Double dollars = euros *1.21;                         // DEPT : Should read this from web service
                editTextDollars.setText(NumberFormat.getCurrencyInstance().format( dollars ));
            }
        });

    }
}