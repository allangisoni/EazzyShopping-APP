package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();



        cartList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvSale);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CartAdapter(cartList, this);
        mRecyclerView.setAdapter(mAdapter);


        CartModel cartModel = new CartModel();

        //cartModel.setCartProductName();
        //cartModel.setCartProductPrice();
        cartModel.setCartProductQuantity(5);
        //cartModel.setCartProductSubTotals();

        if(mAuth.getCurrentUser()!=null)
        {

            mDatabase.child("UserTransactions").child(mAuth.getCurrentUser().getUid()).setValue(cartModel, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError==null)
                    {
                        Toast.makeText(SaleActivity.this, "Data is saved successfully",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
        }


    }
}
