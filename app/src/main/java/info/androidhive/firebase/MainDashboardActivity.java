package info.androidhive.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainDashboardActivity extends AppCompatActivity {

    Button cartAddItems, cartViewItems;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainDashboardActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        cartAddItems = (Button) findViewById(R.id.btnBuyItems);

        cartViewItems= (Button) findViewById(R.id.btnViewBoughtItems);

        cartViewItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainDashboardActivity.this, ProductActivity.class);

                startActivity(intent);

                finish();

            }
        });

        cartAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainDashboardActivity.this, ProductActivity.class);

                startActivity(intent);

                finish();
            }
        });




    }


}
