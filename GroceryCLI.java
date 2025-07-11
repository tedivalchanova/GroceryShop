
import java.util.*;

public class GroceryCLI {
    private Inventory inventory = new Inventory();
    private OrderManager orderManager = new OrderManager(inventory);
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("=== Online Grocery Shop CLI ===");
        while (true) {
            System.out.println("\n1. Add Product\n2. List Products\n3. Update Product\n4. Delete Product\n5. Create Order\n6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1 -> inventory.addProduct(scanner);
                case 2 -> inventory.listProducts();
                case 3 -> inventory.updateProduct(scanner);
                case 4 -> inventory.deleteProduct(scanner);
                case 5 -> orderManager.createOrder(scanner);
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
