package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvProductName, tvProductCategory, tvProductDescription, tvProductPrice;

    public ImageView ivProductImage;

    public ProductsViewHolder(View itemView) {
        super(itemView);

        tvProductName =(TextView) itemView.findViewById(R.id.tvProductName);
//        tvProductCategory =(TextView) itemView.findViewById(R.id.tvProductCategory);
        tvProductDescription =(TextView) itemView.findViewById(R.id.tvProductDescription);
        tvProductPrice =(TextView) itemView.findViewById(R.id.tvProductPrice);
        ivProductImage = (ImageView) itemView.findViewById(R.id.ivProductImage);

    }

    public void bind(final Products products, final ProductsAdapter.OnItemClickListener listener) {

        Picasso.get().load(products.getProductImageView()).error(R.drawable.smarttv).into(ivProductImage);
        tvProductName.setText(products.getProductName());
       // tvProductCategory.setText(products.getProductCategory());
        tvProductDescription.setText(products.getProductDescription());
        tvProductPrice.setText("Ksh."+ " " + Double.toString(products.getProductPrice()));

       // tvProductCategory.setVisibility(View.INVISIBLE);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(products);
                if (getAdapterPosition() != RecyclerView.NO_POSITION) {

                   // List<Products> productsList = new ArrayList<>();
                   // productsList.add(products);

                    Intent intent = new Intent(itemView.getContext(),  SaleActivity.class);
                    intent.putExtra("shoppingItems", products);
                    itemView.getContext().startActivity(intent);


                    //Toast.makeText(itemView.getContext(), "You clicked" + " " + getAdapterPosition(), Toast.LENGTH_LONG).show();
                }


            }
        });


    }

}
