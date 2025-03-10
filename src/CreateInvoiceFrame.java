import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CreateInvoiceFrame extends JFrame {

    ArrayList<LineItem> lineItems = new ArrayList<>();

    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel invoicePanel;

    JPanel addressPanel;
    JPanel addLineItemPanel;
    JPanel addLineItemPanelOptions;

    JLabel titleLabel;

    JTextField customerNameTF;
    JTextField streetTF;
    JTextField cityTF;
    JTextField stateTF;
    JTextField zipTF;

    JButton quitButton;
    JButton clearButton;
    JButton createInvoiceButton;

    JButton addLineItemButton;
    JButton removeLineItemButton;

    JTextArea lineItemTA;

    JScrollPane lineItemScroller;

    public CreateInvoiceFrame() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

//        titleLabel = new JLabel("Create Invoice");
////        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
//        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
//
//        mainPanel.add(titleLabel, BorderLayout.NORTH);


        createInvoicePanel();
        mainPanel.add(invoicePanel, BorderLayout.CENTER);

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,650);
        setTitle("Create Invoice");
        setVisible(true);

    }

    private void createInvoicePanel() {
        invoicePanel = new JPanel();



        invoicePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel("Create Invoice");
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        addressPanel = new JPanel();
        addressPanel.setLayout(new GridLayout(5,2));

        EmptyBorder textFieldPadding = new EmptyBorder(10,10,10,10);

        customerNameTF = new JTextField();
        customerNameTF.setEditable(true);
//        customerNameTF.setText("Customer Name (edit this text)");
        customerNameTF.setBorder(textFieldPadding);
        addressPanel.add(new JLabel("Customer Name"));
        addressPanel.add(customerNameTF);

        streetTF = new JTextField();
        streetTF.setEditable(true);
//        streetTF.setText("Street Address (edit this text)");
        streetTF.setBorder(textFieldPadding);
        addressPanel.add(new JLabel("Street Address"));
        addressPanel.add(streetTF);

        cityTF = new JTextField();
        cityTF.setEditable(true);
//        cityTF.setText("City Name (edit this text)");
        cityTF.setBorder(textFieldPadding);
        addressPanel.add(new JLabel("City Name"));
        addressPanel.add(cityTF);

        stateTF = new JTextField();
        stateTF.setEditable(true);
//        stateTF.setText("State Name (edit this text)");
        stateTF.setBorder(textFieldPadding);
        addressPanel.add(new JLabel("State"));
        addressPanel.add(stateTF);

        zipTF = new JTextField();
        zipTF.setEditable(true);
//        zipTF.setText("Zip Code (edit this text)");
        zipTF.setBorder(textFieldPadding);
        addressPanel.add(new JLabel("Zip Code"));
        addressPanel.add(zipTF);



        addLineItemPanel = new JPanel();
        addLineItemPanel.setLayout(new GridLayout(2,1));

        lineItemTA = new JTextArea(10, 50);
        lineItemTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));
        lineItemTA.setEditable(false);
        lineItemScroller = new JScrollPane(lineItemTA);
        addLineItemPanel.add(lineItemScroller);

        addLineItemPanelOptions = new JPanel();
        addLineItemPanelOptions.setLayout(new GridLayout(1,2));

        addLineItemButton = new JButton("Add Line Item");
        addLineItemButton.addActionListener(e -> {
            AddLineItemDialog dialog = new AddLineItemDialog(CreateInvoiceFrame.this);
            dialog.setVisible(true);

            LineItem lineItem = dialog.getLineItem();
            if (lineItem != null) {
                lineItems.add(lineItem);
                lineItemTA.setText(displayLineitems());
            }
        });
        addLineItemPanelOptions.add(addLineItemButton);
        removeLineItemButton = new JButton("Remove Line Item");
        removeLineItemButton.addActionListener(e -> {
            if (!lineItems.isEmpty()) {
                lineItems.removeLast();
                lineItemTA.setText(displayLineitems());
            }
        });
        addLineItemPanelOptions.add(removeLineItemButton);
        addLineItemPanel.add(addLineItemPanelOptions);






//        invoicePanel.add(titleLabel);
        invoicePanel.add(addressPanel);
        invoicePanel.add(addLineItemPanel);
    }
    private String displayLineitems(){
        String retString = "";
        retString += String.format("%-25s %3s %10s %10s",
                "Item", "Qty", "Price", "Total");

        for (LineItem lineItem : lineItems) {
            retString += "\n" + lineItem.getFormattedString();
        }
        return retString;
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(1, 3));


        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            // Clear all JTextFields
            customerNameTF.setText("");
            streetTF.setText("");
            cityTF.setText("");
            stateTF.setText("");
            zipTF.setText("");

            // Clear JTextArea
            lineItemTA.setText("");

            // Clear the lineItems ArrayList
            lineItems.clear();
        });

        createInvoiceButton = new JButton("Create Invoice");
        createInvoiceButton.addActionListener(e -> {
            if (!customerNameTF.getText().equals("") && !streetTF.getText().equals("") && !cityTF.getText().equals("") && !stateTF.getText().equals("") && !zipTF.getText().equals("") && !lineItems.isEmpty()) {
                Address address = new Address(customerNameTF.getText(), streetTF.getText(), cityTF.getText(), stateTF.getText(), zipTF.getText());
                Invoice invoice = new Invoice(address, lineItems);
                new InvoiceFrame(invoice);
            }

        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPanel.add(clearButton);
        buttonPanel.add(createInvoiceButton);
        buttonPanel.add(quitButton);


    }
}
