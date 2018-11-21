package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewUserTransactions extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    ArrayList<CartModel> usersTransactions=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_transactions);


        mRecyclerView = (RecyclerView) findViewById(R.id.rvUserTransactions);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new UserTransactionsAdapter(usersTransactions, this);
        mRecyclerView.setAdapter(mAdapter);

        getDataFromServer();



    }


    public void getDataFromServer()
    {

        databaseReference.child("UserTransactions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                    {
                        CartModel cartModel=postSnapShot.getValue(CartModel.class);
                        usersTransactions.add(cartModel);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
