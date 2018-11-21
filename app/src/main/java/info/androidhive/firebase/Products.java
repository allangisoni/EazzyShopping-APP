package info.androidhive.firebase;

import android.widget.ImageView;

public class Products {

    public String productName, productCategory, productDescription;

    public String productImageView;

    public double productPrice;


    public  Products(){

    }

    public Products(String productName, String productCategory, String productDescription, double productPrice, String productImageView){

        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImageView = productImageView;
    }


    public String getProductName() {
        return "Product Name:" +" "+ productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return "Product Category:" +" "+ productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return "Product Description:" +" "+productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return   productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    public String getProductImageView() {
        return productImageView;
    }

    public void setProductImageView(String productImageView) {
        this.productImageView = productImageView;
    }
}
