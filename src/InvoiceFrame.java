import javax.swing.*;
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

    JTextArea addressField;

    JTextArea displayLineItemsField;
    JScrollPane scroller;

    JButton quitButton;

    JLabel titleLabel;

    public InvoiceFrame(Invoice invoice) {
        setTitle("Create Invoice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Invoice");
//        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        mainPanel.add(titleLabel, BorderLayout.NORTH);


//        createInvoicePanel();
//        mainPanel.add(invoicePanel, BorderLayout.CENTER);

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,1000);
        setVisible(true);

    }
    private void createInvoicePanel() {

    }
    private void createButtonPanel() {
        buttonPanel = new JPanel();
        quitButton = new JButton("Close");
        quitButton.addActionListener((ActionEvent ae) -> dispose());
        buttonPanel.add(quitButton);
    }
}
