package e_commerce_order_management;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Author: Sumit Vilas Awatade
 * Date: 27-Jun-2026
 */
public class CollectionUtils {

    // E1. Sort orders by totalAmount in descending order
    public static void sortOrdersByAmount() {

        System.out.println("\n========== E1 ==========");
        System.out.println("Orders Sorted by Total Amount (Descending)\n");

        DataStore.o_list
                .stream()
                .sorted(Comparator.comparingDouble(Order::getTotalAmount).reversed())
                .forEach(System.out::println);

        System.out.println("===============================================");
    }

    // E2. Sort products alphabetically by name, then price ascending
    public static void sortProductsByNameAndPrice() {

        System.out.println("\n========== E2 ==========");
        System.out.println("Products Sorted by Name and Price\n");

        DataStore.p_list
                .stream()
                .sorted(Comparator.comparing(Product::getName)
                        .thenComparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("===============================================");
    }

    // E3. Store unique customers in LinkedHashSet
    public static void uniqueCustomers() {

        System.out.println("\n========== E3 ==========");
        System.out.println("Unique Customers\n");

        Set<Customer> set = new LinkedHashSet<>();

        DataStore.o_list
                .stream()
                .map(Order::getCustomer)
                .forEach(set::add);

        set.forEach(System.out::println);

        System.out.println("===============================================");
    }

    // E4. TreeMap<OrderStatus, List<Order>>
    public static void ordersByStatus() {

        System.out.println("\n========== E4 ==========");
        System.out.println("Orders Grouped By Status\n");

        Map<String, List<Order>> map = DataStore.o_list
                .stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        TreeMap::new,
                        Collectors.toList()));

        map.forEach((status, orders) -> {

            System.out.println("\nStatus : " + status);

            orders.forEach(System.out::println);

        });

        System.out.println("===============================================");
    }

    // E5. Process lowest orderId first using PriorityQueue
    public static void processOrders() {

        System.out.println("\n========== E5 ==========");
        System.out.println("Processing First 3 Orders\n");

        PriorityQueue<Order> pq =
                new PriorityQueue<>(Comparator.comparingInt(Order::getOrderId));

        pq.addAll(DataStore.o_list);

        System.out.println("\n First Order");
        System.out.println(pq.poll());

        System.out.println("\nSecond Order");
        System.out.println(pq.poll());

        System.out.println("\nThird Order");
        System.out.println(pq.poll());

        System.out.println("===============================================");
    }

}