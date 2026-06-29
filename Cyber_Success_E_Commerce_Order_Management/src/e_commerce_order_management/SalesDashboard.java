package e_commerce_order_management;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: Sumit Vilas Awatade
 * Date: 27-Jun-2026
 */
public class SalesDashboard {

	public static void generateReport(List<Order> orders)  {

        // =====================================================
        // Total Revenue from DELIVERED Orders
        // =====================================================
        System.out.println("\n========== Sales Report 1 ==========");
        System.out.println("Total Revenue from DELIVERED Orders\n");

        double revenue = orders
                .stream()
                .filter(o -> o.getStatus().equals("DELIVERED"))
                .mapToDouble(o -> o.getTotalAmount())
                .sum();

        System.out.println("Total Revenue : " + revenue);

        // =====================================================
        // Category Wise Revenue
        // =====================================================
        System.out.println("\n========== Sales Report 2 ==========");
        System.out.println("Category Wise Revenue\n");

        Map<String, Double> categoryRevenue =  orders
                .stream()
                .filter(o -> o.getStatus().equals("DELIVERED"))
                .collect(Collectors.groupingBy(
                        o -> o.getProduct().getCategory(),
                        Collectors.summingDouble(Order::getTotalAmount)));

        categoryRevenue.forEach((category, amount) ->
                System.out.println(category + " : " + amount));

        // =====================================================
        // Top 3 Selling Products
        // =====================================================
        System.out.println("\n========== Sales Report 3 ==========");
        System.out.println("Top 3 Selling Products\n");

        orders
                .stream()
                .collect(Collectors.groupingBy(
                        o -> o.getProduct().getName(),
                        Collectors.summingInt(Order::getQuantity)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(System.out::println);

        // =====================================================
        // Top 2 Customers by Total Spend
        // =====================================================
        System.out.println("\n========== Sales Report 4 ==========");
        System.out.println("Top 2 Customers By Spend\n");

        orders
                .stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCustomer().getName(),
                        Collectors.summingDouble(Order::getTotalAmount)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(2)
                .forEach(System.out::println);

        // =====================================================
        // Cancelled Orders
        // =====================================================
        System.out.println("\n========== Sales Report 5 ==========");
        System.out.println("Cancelled Orders\n");

        orders
                .stream()
                .filter(o -> o.getStatus().equals("CANCELLED"))
                .forEach(o -> System.out.println(
                        o.getCustomer().getName()
                                + " | Loss Amount : "
                                + o.getTotalAmount()));

        // =====================================================
        // City Wise Order Count
        // =====================================================
        System.out.println("\n========== Sales Report 6 ==========");
        System.out.println("City Wise Order Count\n");

        Map<String, Long> cityOrders =  orders
                .stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCustomer().getCity(),
                        Collectors.counting()));

        cityOrders.forEach((city, count) ->
                System.out.println(city + " : " + count));

        System.out.println("\n===============================================");
    }

}