package info.androidhive.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvProductName, tvProductCategory, tvProductDescription, tvProductPrice;

    public ImageView ivProductImage;

    public ProductsViewHolder(View itemView) {
        super(itemView);

        tvProductName =(TextView) itemView.findViewById(R.id.tvProductName);
        tvProductCategory =(TextView) itemView.findViewById(R.id.tvProductCategory);
        tvProductDescription =(TextView) itemView.findViewById(R.id.tvProductDescription);
        tvProductPrice =(TextView) itemView.findViewById(R.id.tvProductPrice);
        ivProductImage = (ImageView) itemView.findViewById(R.id.ivProductImage);

    }
}
