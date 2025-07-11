
import java.util.*;

public class OrderManager {
    private Inventory inventory;

    public OrderManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void createOrder(Scanner scanner) {
        Map<Product, Integer> orderItems = new HashMap<>();
        System.out.println("Enter product names and quantities (type 'done' to finish):");
        while (true) {
            System.out.print("Product name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;
            Product p = inventory.getProduct(name);
            if (p == null) {
                System.out.println("Product not found.");
                continue;
            }
            System.out.print("Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine(); 
            orderItems.put(p, qty);
        }

        List<String> visited = new ArrayList<>();
        visited.add("[0,0]");
        boolean fail = false;
        for (Map.Entry<Product, Integer> entry : orderItems.entrySet()) {
            Product p = entry.getKey();
            int needed = entry.getValue();
            if (p.getQuantity() < needed) {
                System.out.printf("❌ Not enough stock: %s (requested %d, available %d)%n", p.getName(), needed, p.getQuantity());
                fail = true;
            }
        }

        if (fail) {
            System.out.println("❌ We cannot fulfill your order right now – not enough stock.");
            return;
        }

        for (Map.Entry<Product, Integer> entry : orderItems.entrySet()) {
            Product p = entry.getKey();
            visited.add("[" + p.getX() + "," + p.getY() + "]");
            p.setQuantity(p.getQuantity() - entry.getValue());
        }
        visited.add("[0,0]");
        System.out.println("✅ Order ready! Please collect it at the desk");
        System.out.println("Visited locations: " + visited);
    }
}
