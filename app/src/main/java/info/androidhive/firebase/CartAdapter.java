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

        holder.cartProductName.setText("Product Name:"+" " +cartModel.getCartProductName());
        holder.cartProductPrice.setText("Product Price:"+" " +Double.toString(cartModel.getCartProductPrice()));
        holder.cartProductQuantity.setText("Product Quantity:"+" " +Integer.toString(3));
        holder.cartProductSubTotals.setText("Product SubTotals"+" " +"Ksh."+Double.toString(cartModel.getCartProductSubTotals()));
    }

    @Override
    public int getItemCount() {

        return cartModelList.size();
    }
}
