package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentDetailsActivity extends AppCompatActivity {

    TextView tvTotalAmount;
    Button  buttonProcessPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tvTotalAmount = (TextView) findViewById(R.id.tvProductTotals);

        buttonProcessPayment = (Button) findViewById(R.id.buttonProcessPayment);

        Intent intent = getIntent();

        if(intent.getStringExtra("Totals") != null){

            tvTotalAmount.setText(intent.getStringExtra("Totals"));
        }



        buttonProcessPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(PaymentDetailsActivity.this, "Data is saved successfully",
                        Toast.LENGTH_SHORT).show();

                Toast.makeText(PaymentDetailsActivity.this, "Thank you for shopping with us", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentDetailsActivity.this, MainDashboardActivity.class));

            }
        });

    }
}
