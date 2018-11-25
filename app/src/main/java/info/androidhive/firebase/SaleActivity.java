package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SaleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<CartModel> cartList;

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;
    Products myProducts;

    private TextView tvTotals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tvTotals = (TextView) findViewById(R.id.tvTotals);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();





        cartList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvSale);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Intent intent = getIntent();
        CartModel cartModel = new CartModel();

        if(intent.getParcelableExtra("shoppingItems") != null){

             myProducts = intent.getParcelableExtra("shoppingItems");


            // Toast.makeText(SaleActivity.this, "" +myProducts.getProductName(), Toast.LENGTH_SHORT).show();


        }



        // specify an adapter (see also next example)
        mAdapter = new CartAdapter(cartList, this);
        mRecyclerView.setAdapter(mAdapter);

        getCartItems();


    }

    private void getCartItems(){

        Double subtotal = myProducts.getProductPrice() * 5;

        CartModel cartModel = new CartModel(myProducts.getProductName(), 5, myProducts.getProductPrice(), subtotal);

        tvTotals.setText("Ksh." +Double.toString(subtotal));

        //Toast.makeText(SaleActivity.this, "" +myProducts.getProductName(), Toast.LENGTH_SHORT).show();

        cartList.add(cartModel);

        mAdapter.notifyDataSetChanged();

        if(mAuth.getCurrentUser()!=null)
        {

            mDatabase.child("UserTransactions").child(mAuth.getCurrentUser().getUid()).setValue(cartModel, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError==null)
                    {
                        // Toast.makeText(SaleActivity.this, "Data is saved successfully",
                        //       Toast.LENGTH_SHORT).show();
                        // finish();
                    }
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.paymenu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.payForItems:

                 Intent intent = new Intent(SaleActivity.this,  PaymentDetailsActivity.class);

                 intent.putExtra("Totals", tvTotals.getText().toString());

                 startActivity(intent);

                //startActivity(new Intent(SaleActivity.this, PaymentDetailsActivity.class));

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }

}
