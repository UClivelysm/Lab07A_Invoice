import java.util.ArrayList;

public class Invoice {
    private Address address;
    private ArrayList<LineItem> lineItems;
    private double invoiceTotal;

    public Invoice(Address address, ArrayList<LineItem> lineItems) {
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getAddress() {
        return address.getFormattedAddress();
    }
    public String getLineItems() {
        String retString = "";
        retString += String.format("%-25s %3s %10s %10s",
                "Item", "Qty", "Price", "Total");

        for (LineItem lineItem : lineItems) {
            retString += "\n" + lineItem.getFormattedString();
        }
        return retString;
    }
    public double getInvoiceTotal() {
        for (LineItem lineItem : lineItems) {
            invoiceTotal += lineItem.calcLineTotal();
        }
        return invoiceTotal;
    }
}
