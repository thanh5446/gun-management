import java.io.Serializable;
public class Product implements Serializable {
    protected String nameProduct;
    protected int ID;
    protected String quantity;
    protected String price;
    protected String category;
    protected String sizeProduct;

    public Product(int ID, String nameProduct, String quantity, String price, String category, String sizeProduct) {
        this.nameProduct = nameProduct;
        this.ID = ID;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.sizeProduct = sizeProduct;
    }
    public Product(){ }
    public static void display(Product product){
        System.out.println(product.ID);
        System.out.println(product.nameProduct);
    }
}
