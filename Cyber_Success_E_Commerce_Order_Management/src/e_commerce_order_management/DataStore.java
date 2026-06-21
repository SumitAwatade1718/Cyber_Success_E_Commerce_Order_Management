package e_commerce_order_management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class DataStore {
	public static List<Product> p_list = new ArrayList<>();
	public static List<Customer> c_list = new ArrayList<>();
	public static List<Order> o_list = new ArrayList<>();

    static {

    	// 
    	// Products (5 Product objects across all 4 categories)
    	// 
    	Product p1 = new Product(101, "Laptop", "ELECTRONICS", 52000, 2);
    	Product p2 = new Product(102, "iPhone 17", "ELECTRONICS", 125000, 5);
    	Product p3 = new Product(103, "Hoodie", "CLOTHING", 1200, 10);
    	Product p4 = new Product(104, "Rice Bag", "GROCERY", 900, 60);
    	Product p5 = new Product(105, "Rich Dad Poor Dad", "BOOKS", 700, 25);
    	p_list.add(p1);
    	p_list.add(p2);
    	p_list.add(p3);
    	p_list.add(p4);
    	p_list.add(p5);
    	
    	// 
    	// Customers
    	// 
    	Customer c1 = new Customer(1, "Sumit Awatade", "Pune", "GOLD");
    	Customer c2 = new Customer(2, "Rahul Awatade", "Sangola", "SILVER");
    	Customer c3 = new Customer(3, "Priyansh Ingole", "Pune", "BRONZE");
    	Customer c4 = new Customer(4, "Shreyansh Ingole", "Pandharpur", "GOLD");

    	c_list.add(c1);
    	c_list.add(c2);
    	c_list.add(c3);
    	c_list.add(c4);  	

    	// 
    	// Orders
    	// 
    	Order o1 = new Order(1, c1, p1, 1, 52000, "DELIVERED", LocalDate.now().minusDays(5));
    	Order o2 = new Order(2, c2, p2, 1, 125000, "PLACED", LocalDate.now().minusDays(2));
    	Order o3 = new Order(3, c3, p3, 2, 2400, "SHIPPED", LocalDate.now().minusDays(15));
    	Order o4 = new Order(4, c4, p4, 5, 4500, "DELIVERED", LocalDate.now().minusDays(25));
    	Order o5 = new Order(5, c1, p5, 3, 2100, "PLACED", LocalDate.now().minusDays(35));
    	Order o6 = new Order(6, c2, p2, 1, 125000, "CANCELLED", LocalDate.now().minusDays(10));
    	Order o7 = new Order(7, c3, p1, 1, 52000, "SHIPPED", LocalDate.now());
    	Order o8 = new Order(8, c4, p3, 4, 4800, "DELIVERED", LocalDate.now().minusDays(1));
    	Order o9 = new Order(9, c1, p4, 8, 7200, "CANCELLED", LocalDate.now().minusDays(40));
    	Order o10 = new Order(10, c2, p5, 5, 3500, "DELIVERED", LocalDate.now());
    	o_list.add(o1);
    	o_list.add(o2);
    	o_list.add(o3);
    	o_list.add(o4);
    	o_list.add(o5);
    	o_list.add(o6);
    	o_list.add(o7);
    	o_list.add(o8);
    	o_list.add(o9);
    	o_list.add(o10);
    }

}
