import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {
    Product product;
    LineItem lineItem;
    @BeforeEach
    void setUp() {
        product = new Product("testItem", 5.99);
        lineItem = new LineItem(product, 7);
    }

    @org.junit.jupiter.api.Test
    void testCalcLineTotal() {
        assertEquals(lineItem.calcLineTotal(), 41.93);
    }

    @org.junit.jupiter.api.Test
    void testGetFormattedString() {

        String expected = String.format("%-25s %3d %10s %10s",
                "testItem", 7, "5.99", "41.93");
        String actual = lineItem.getFormattedString();

        assertEquals(expected, actual, "Formatted string output should match");
    }
}