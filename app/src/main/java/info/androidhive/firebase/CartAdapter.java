package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    List<CartModel> cartModelList;
    Context context;

    public CartAdapter(List<CartModel> cartModelList,  Context context ){
        this.cartModelList = cartModelList;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_items, parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {

        CartModel cartModel = cartModelList.get(position);

        holder.cartProductName.setText(cartModel.getCartProductName());
        holder.cartProductPrice.setText(Double.toString(cartModel.getCartProductPrice()));
        holder.cartProductQuantity.setText(cartModel.getCartProductQuantity());
        holder.cartProductSubTotals.setText(Double.toString(cartModel.getCartProductSubTotals()));
    }

    @Override
    public int getItemCount() {

        return cartModelList.size();
    }
}
