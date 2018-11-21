package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UserTransactionsAdapter extends RecyclerView.Adapter<UserTransctionsViewHolder> {


    List<CartModel> cartModelList;
    Context context;

    public UserTransactionsAdapter(List<CartModel> cartModelList,  Context context ){
        this.cartModelList = cartModelList;
        this.context = context;
    }

    @Override
    public UserTransctionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usertransaction_item_list, parent,false);
        return new UserTransctionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserTransctionsViewHolder holder, int position) {

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
