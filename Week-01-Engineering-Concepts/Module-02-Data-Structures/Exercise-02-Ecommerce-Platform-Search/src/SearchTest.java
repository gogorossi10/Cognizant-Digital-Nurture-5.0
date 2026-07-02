public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {

                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(110, "Mobile", "Electronics"),
                new Product(102, "Book", "Education"),
                new Product(108, "Watch", "Accessories")

        };

        System.out.println("Linear Search");

        Product result1 = SearchAlgorithms.linearSearch(products, 102);

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product not found");

        SearchAlgorithms.sortProducts(products);

        System.out.println("\nBinary Search");

        Product result2 = SearchAlgorithms.binarySearch(products, 102);

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product not found");

        System.out.println("\nAnalysis");
        System.out.println("Linear Search Time Complexity : O(n)");
        System.out.println("Binary Search Time Complexity : O(log n)");
        System.out.println("Binary Search is more suitable for large sorted datasets.");

    }

}