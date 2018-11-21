package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    List<Products> products;
    Context context;

    private final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Products products);
    }

    public  ProductsAdapter(List<Products> products,Context context, OnItemClickListener listener) {

        this.products = products;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_list, parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {

        holder.bind(products.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
