import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchDemo {

    static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    static int binarySearch(String[] names, String target) {
        int low = 0, high = names.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = names[mid].compareToIgnoreCase(target);
            if (result == 0)
                return mid;
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Mouse", "Electronics"),
                new Product(3, "Phone", "Electronics")
        };

        Product p = linearSearch(products, "Phone");

        if (p != null)
            System.out.println("Found: " + p.productName);

        String[] names = {"Laptop", "Mouse", "Phone"};
        Arrays.sort(names);

        System.out.println(binarySearch(names, "Phone"));
    }
}