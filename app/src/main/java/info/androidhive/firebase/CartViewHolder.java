package info.androidhive.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    public TextView cartProductName, cartProductQuantity, cartProductPrice, cartProductSubTotals;

    public CartViewHolder(View itemView) {
        super(itemView);

        cartProductName = (TextView) itemView.findViewById(R.id.tvcartName);
        cartProductQuantity = (TextView) itemView.findViewById(R.id.tvcartQuantity);
        cartProductPrice = (TextView) itemView.findViewById(R.id.tvcartPrice);
        cartProductSubTotals = (TextView) itemView.findViewById(R.id.tvcartProductTotal);
    }
}
