import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
Whats left to do:

Display the address
display the line items
display the total
 */

public class InvoiceFrame extends JFrame {
    JPanel mainPanel;
    JPanel invoicePanel;
    JPanel buttonPanel;
    JPanel fixMePanel;

    JTextArea addressField;

    JTextArea displayLineItemsField;
    JScrollPane scroller;


    JButton quitButton;

    JLabel titleLabel;
    JLabel totalLabel;

    public InvoiceFrame(Invoice invoice) {
        setTitle("Create Invoice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        createInvoicePanel(invoice);
        mainPanel.add(invoicePanel, BorderLayout.CENTER);

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,500);
        setVisible(true);

    }
    private void createInvoicePanel(Invoice invoice) {
        int boarderPadding = 10;
        EmptyBorder paddingBorder = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        LineBorder lineBorder = new LineBorder(Color.BLACK);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, paddingBorder);
        EmptyBorder outerPadding = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        CompoundBorder compoundBorder2 = new CompoundBorder(outerPadding, compoundBorder);


        invoicePanel = new JPanel();
        invoicePanel.setLayout(new BorderLayout());
        titleLabel = new JLabel("Invoice");
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        invoicePanel.add(titleLabel, BorderLayout.NORTH);

        fixMePanel = new JPanel();
        fixMePanel.setLayout(new GridLayout(2,1));

        addressField = new JTextArea(4,36);
        addressField.setEditable(false);
        addressField.setText(invoice.getAddress());
        fixMePanel.add(addressField);


        displayLineItemsField = new JTextArea(10, 60);
        displayLineItemsField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        displayLineItemsField.setEditable(false);
        displayLineItemsField.setText(invoice.getLineItems());
        scroller = new JScrollPane(displayLineItemsField);
        fixMePanel.add(scroller);

        fixMePanel.setBorder(compoundBorder2);
        invoicePanel.add(fixMePanel, BorderLayout.CENTER);


        totalLabel = new JLabel("AMOUNT DUE: $" + invoice.getInvoiceTotal());
        invoicePanel.add(totalLabel, BorderLayout.SOUTH);



        invoicePanel.setBorder(compoundBorder2);
    }
    private void createButtonPanel() {
        buttonPanel = new JPanel();
        quitButton = new JButton("Close");
        quitButton.addActionListener((ActionEvent ae) -> dispose());
        buttonPanel.add(quitButton);
    }
}
