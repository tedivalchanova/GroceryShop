
import java.util.*;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("X Location: ");
        int x = scanner.nextInt();
        System.out.print("Y Location: ");
        int y = scanner.nextInt();
        scanner.nextLine(); 
        products.put(name, new Product(name, price, quantity, x, y));
        System.out.println("Product added.");
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        products.values().forEach(System.out::println);
    }

    public void updateProduct(Scanner scanner) {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        Product p = products.get(name);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("New quantity: ");
        p.setQuantity(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.println("Quantity updated.");
    }

    public void deleteProduct(Scanner scanner) {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        products.remove(name);
        System.out.println("Product deleted if it existed.");
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
