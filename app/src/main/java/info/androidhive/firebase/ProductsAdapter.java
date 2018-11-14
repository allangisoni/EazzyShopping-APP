package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    List<Products> products;
    Context context;

    public  ProductsAdapter(List<Products> products,Context context) {

        this.products = products;
        this.context = context;
    }


    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_list, parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {

        Products product = products.get(position);

        holder.tvProductName.setText(product.getProductName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
