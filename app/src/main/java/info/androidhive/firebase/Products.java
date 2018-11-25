package info.androidhive.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Products implements Parcelable {

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
        return  productName;
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
        return productDescription;
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

    protected Products(Parcel in) {
        productName= in.readString();
        productCategory = in.readString();
        productDescription = in.readString();
        productPrice = in.readDouble();
        productImageView= in.readString();
    }



    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(productCategory);
        dest.writeString(productDescription);
        dest.writeDouble(productPrice);
        dest.writeString(productImageView);
    }


}
