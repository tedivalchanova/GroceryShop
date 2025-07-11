
public class Product {
    private String name;
    private double price;
    private int quantity;
    private int x, y;

    public Product(String name, double price, int quantity, int x, int y) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.x = x;
        this.y = y;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String toString() {
        return String.format("Product: %s, Price: %.2f, Quantity: %d, Location: (%d,%d)", name, price, quantity, x, y);
    }
}
