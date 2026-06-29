package e_commerce_order_management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: Sumit Vilas Awatade
 * Date: 21-Jun-2026
 */
public class InventoryService {

    // Inventory Alert System
    public static void inventoryAlert() {

        System.out.println("\n========== Inventory Alert ==========");

        // ============================================
        // CRITICAL PRODUCTS (Stock < 5)
        // ============================================
        System.out.println("\nCRITICAL PRODUCTS (Stock < 5)\n");

        List<Product> critical = DataStore.p_list
                .stream()
                .filter(p -> p.getStock() < 5)
                .collect(Collectors.toList());

        critical.forEach(p ->
                System.out.println(
                        p.getName()
                        + " | Stock : "
                        + p.getStock()
                        + " | CRITICAL"));

        // ============================================
        // LOW STOCK PRODUCTS (Stock 5 - 20)
        // ============================================
        System.out.println("\nLOW STOCK PRODUCTS (Stock 5 - 20)\n");

        List<Product> low = DataStore.p_list
                .stream()
                .filter(p -> p.getStock() >= 5 && p.getStock() <= 20)
                .collect(Collectors.toList());

        low.forEach(p ->
                System.out.println(
                        p.getName()
                        + " | Stock : "
                        + p.getStock()
                        + " | LOW"));

        // ============================================
        // Map<String,List<Product>>
        // ============================================

        Map<String, List<Product>> map = new HashMap<>();

        map.put("CRITICAL", critical);
        map.put("LOW", low);

        System.out.println("\n========== Inventory Map ==========\n");

        map.forEach((status, products) -> {

            System.out.println(status);

            products.forEach(System.out::println);

            System.out.println();

        });

        System.out.println("===============================================");
    }

}