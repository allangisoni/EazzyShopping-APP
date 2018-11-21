package info.androidhive.firebase;

public class CartModel {
    private String cartProductName;

    private int cartProductQuantity;

    private double cartProductPrice, cartProductSubTotals, cartProductTotal;




    public CartModel(){

    }

    public CartModel(String cartProductName,int cartProductQuantity, double cartProductPrice, double cartProductSubTotals ){

        this.cartProductName = cartProductName;
        this.cartProductQuantity = cartProductQuantity;
        this.cartProductPrice = cartProductPrice;
        this.cartProductSubTotals = cartProductSubTotals;

    }

    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public int getCartProductQuantity() {
        return cartProductQuantity;
    }

    public void setCartProductQuantity(int cartProductQuantity) {
        this.cartProductQuantity = cartProductQuantity;
    }

    public double getCartProductPrice() {
        return cartProductPrice;
    }

    public void setCartProductPrice(double cartProductPrice) {
        this.cartProductPrice = cartProductPrice;
    }

    public double getCartProductSubTotals() {
        return cartProductSubTotals;
    }

    public void setCartProductSubTotals(double cartProductSubTotals) {
        this.cartProductSubTotals = cartProductSubTotals;
    }

    public double getCartProductTotal() {
        return cartProductTotal;
    }

    public void setCartProductTotal(double cartProductTotal) {
        this.cartProductTotal = cartProductTotal;
    }
}
