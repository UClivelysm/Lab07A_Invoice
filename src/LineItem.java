//public class LineItem {
//    private Product product;
//    private int quantity;
//
//    public LineItem(Product product, int quantity) {
//        this.product = product;
//        this.quantity = quantity;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//    public double calcLineTotal() {
//        return product.getUnitPrice() * quantity;
//    }
//    public String getFormattedString() {
//        String formattedString = "";
//
//
//
//        return formattedString;
//    }
//}
import java.text.DecimalFormat;

public class LineItem {
    private Product product;
    private int quantity;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calcLineTotal() {
        return Math.round(this.product.getUnitPrice() * quantity * 100.0) / 100.0;
    }

    public String getFormattedString() {
        return String.format("%-25s %3d %10s %10s",
                this.product.getProductName(),
                quantity,
                df.format(this.product.getUnitPrice()),
                df.format(calcLineTotal()));
    }
}

