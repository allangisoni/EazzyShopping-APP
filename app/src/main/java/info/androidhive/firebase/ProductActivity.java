package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Products> productsList;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);

        productsList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvProducts);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ProductsAdapter(productsList, this, new ProductsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Products products) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);

        getProducts();


    }


    private void getProducts(){

        Products products = new Products("Samsung 32 inch smart TV", "Electronic Devices", "This is the best television of the 21st century", 32000.00,"https://rukminim1.flixcart.com/image/832/832/television/z/b/6/samsung-32j4003-original-imaezvg8eynmheds.jpeg?q=70");
        productsList.add(products);


        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "This is the best television of the 21st century",  52000.00, "https://rukminim1.flixcart.com/image/832/832/television/z/b/6/samsung-32j4003-original-imaezvg8eynmheds.jpeg?q=70");
        productsList.add(products);

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.cartmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.checkoutItems:

                startActivity(new Intent(ProductActivity.this, SaleActivity.class));

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }
}
