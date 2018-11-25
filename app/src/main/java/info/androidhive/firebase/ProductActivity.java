package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
    Products productList= new Products();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        productsList = new ArrayList<>();


        mRecyclerView = (RecyclerView) findViewById(R.id.rvProducts);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
       // mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ProductsAdapter(productsList, this, new ProductsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Products products) {



               // productList = products;

            }
        });
        mRecyclerView.setAdapter(mAdapter);

        getProducts();


    }


    private void getProducts(){

        Products products = new Products("Samsung 32 inch smart TV", "Electronic Devices", "Best Tv of the 21st century", 32000.00,"https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);


        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 32 inch smart TV", "Electronic Devices", "Best Tv of the 21st century", 32000.00,"https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);


        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
        productsList.add(products);

        products = new Products("Samsung 40 inch smart TV", "Electronic Devices", "Best Tv of the 21st century",  52000.00, "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjasKfnr-_eAhVP2xoKHXydBwIQjRx6BAgBEAU&url=https%3A%2F%2Fwww.currys.co.uk%2Fgbuk%2Ftv-buyers-guide-1959-commercial.html&psig=AOvVaw2P2vl-CobQ1Q-MWRV9YsVi&ust=1543229423998125");
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

               // Intent intent = new Intent(this,  SaleActivity.class);
                //Bundle bundle = new Bundle();
                //bundle.putParcelableArrayList("shoppingItems",productList);

                //intent.putParcelableArrayListExtra("shoppingItems", productList);
               // startActivity(intent);

               startActivity(new Intent(ProductActivity.this, SaleActivity.class));

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }
}
