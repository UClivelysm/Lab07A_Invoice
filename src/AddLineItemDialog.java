import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddLineItemDialog extends JDialog {
    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JButton submitButton;
    private LineItem lineItem;  // To store the created LineItem

    public AddLineItemDialog(JFrame parent) {
        super(parent, "Add Line Item", true);

        setLayout(new GridLayout(4, 2));

        // Create fields for productName, unitPrice, and quantity
        productNameField = new JTextField(20);
        unitPriceField = new JTextField(20);
        quantityField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Add components to the dialog
        add(new JLabel("Product Name:"));
        add(productNameField);
        add(new JLabel("Unit Price:"));
        add(unitPriceField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(submitButton);

        // Set dialog properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String productName = productNameField.getText();
                    double unitPrice = Double.parseDouble(unitPriceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());

                    // Create the Product and LineItem objects
                    Product product = new Product(productName, unitPrice);
                    lineItem = new LineItem(product, quantity);

                    // Close the dialog
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddLineItemDialog.this,
                            "Please enter valid numbers for Unit Price and Quantity.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Get the created LineItem object
    public LineItem getLineItem() {
        return lineItem;
    }
}
