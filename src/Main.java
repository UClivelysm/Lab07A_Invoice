import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
        Product product1 = new Product("testItem", 5.99);
        LineItem lineItem = new LineItem(product1, 7);
        lineItems.add(lineItem);
        Address address = new Address("testCustomer", "testStreet", "testCity", "testState", "testZIP");
        Invoice invoice = new Invoice(address, lineItems);

        System.out.println(invoice.getAddress());
        System.out.println(invoice.getLineItems());
        System.out.println(invoice.getInvoiceTotal());
    }
}