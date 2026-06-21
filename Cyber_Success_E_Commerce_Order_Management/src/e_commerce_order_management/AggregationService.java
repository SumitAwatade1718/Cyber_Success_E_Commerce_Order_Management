package e_commerce_order_management;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: Sumit Vilas Awatade
 * Date: 20-Jun-2026
 */
public class AggregationService {

    // C1. Count total number of SHIPPED orders
    public static void countShippedOrders() {

        System.out.println("\n========== C1 ==========");
        System.out.println("Total SHIPPED Orders\n");

        long count = DataStore
                .o_list
                .stream()
                .filter(o->o.getStatus().equals("SHIPPED"))
                .count();

        System.out.println("Total Shipped Orders : " + count);
        System.out.println("===============================================");
    }

    // C2. Count number of orders per category
    public static void countOrdersPerCategory() {

        System.out.println("\n========== C2 ==========");
        System.out.println("Orders Per Category\n");

        Map<String, Long> map = DataStore
                                         .o_list
                                         .stream()
                                         .collect(Collectors.groupingBy(o->o.getProduct().getCategory(),Collectors.counting()));

        System.out.println(map);
        System.out.println("===============================================");
    }

    // C3. Calculate total revenue from DELIVERED orders
    public static void totalDeliveredRevenue() {

        System.out.println("\n========== C3 ==========");
        System.out.println("Total Revenue From DELIVERED Orders\n");

        double total = DataStore
                                .o_list
                                .stream()
                                .filter(o -> o.getStatus().equals("DELIVERED"))
                                .mapToDouble(o -> o.getTotalAmount())
                                .sum();

        System.out.println("Total Revenue : " + total);
        System.out.println("===============================================");
    }

    // C4. Find total quantity of ELECTRONICS products sold
    public static void totalElectronicsQuantity() {
    	
        System.out.println("\n========== C4 ==========");
        System.out.println("Total ELECTRONICS Quantity Sold\n");

        int total = DataStore
                             .o_list
                             .stream()
                             .filter(o -> o.getProduct().getCategory().equals("ELECTRONICS"))
                             .mapToInt(o -> o.getQuantity())
                             .sum();

        System.out.println("Total Quantity Sold : " + total);
        System.out.println("===============================================");
    }

    // C5. Calculate average order value for GOLD tier customers
    public static void averageGoldOrderValue() {

        System.out.println("\n========== C5 ==========");
        System.out.println("Average Order Value Of GOLD Customers\n");

        double average = DataStore
                                  .o_list
                                  .stream()
                                  .filter(o -> o.getCustomer().getTier().equals("GOLD"))
                                  .mapToDouble(o -> o.getTotalAmount())
                                  .average()
                                  .orElse(0);
                                  

        System.out.println("Average Order Value : " + average);
        System.out.println("===============================================");
    }

}