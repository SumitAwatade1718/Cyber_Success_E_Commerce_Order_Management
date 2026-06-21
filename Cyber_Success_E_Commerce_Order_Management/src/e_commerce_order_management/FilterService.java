package e_commerce_order_management;

import java.time.LocalDate;
/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class FilterService {
	// A1. Get all DELIVERED orders with totalAmount > 2000
	public static void getDeliveredHighValue() {
	
		System.out.println("\n========== A1 ==========");
		System.out.println("DELIVERED Orders with Total Amount > 2000\n");
		DataStore
		         .o_list
		         .stream()
		         .filter(o->o.getStatus().equals("DELIVERED") && o.getTotalAmount()>2000)
		         .forEach(System.out::println);
		System.out.println("====================\n");
		
	}
	// A2. Get all ELECTRONICS products with stock < 10
		public static void getLowStockElectronics() {
		   System.out.println("\n========== A2 ==========");
		   System.out.println("Low Stock ELECTRONICS Products\n");
		    DataStore
		             .p_list
		             .stream()
		             .filter(e->e.getCategory().equals("ELECTRONICS") && e.getStock()<10)
	                 .forEach(System.out::println);	 
		    System.out.println("===============================================\n");
		}
		// A3. Get all GOLD tier customers who have placed at least one CANCELLED order
		public static void getGoldCancelledCustomers() {  
			System.out.println("\n========== A3 ==========");
			System.out.println("GOLD Customers with CANCELLED Orders\n");
		    DataStore
		             .o_list
		             .stream()
		             .filter(c->c.getStatus().equals("CANCELLED"))
		             .map(c->c.getCustomer())
		             .filter(c->c.getTier().equals("GOLD"))
		             .forEach(System.out::println);
		    System.out.println("===============================================\n");
		} 
		 // A4. Get all orders placed in the last 30 days
		public static void getLast30DayOrder() {
			System.out.println("\n========== A4 ==========");
			System.out.println("Orders Placed in Last 30 Days\n");
			DataStore
			         .o_list
			         .stream()
			         .filter(o->o.getOrderDate().isAfter(LocalDate.now().minusDays(30)))
			         .forEach(System.out::println);
			 System.out.println("===============================================\n");
		}
		//A5. Get all orders where the product belongs to GROCERY category and quantity > 3.
		public static void getGroceryOrders() {
			System.out.println("\n========== A5 ==========");
			System.out.println("GROCERY Orders with Quantity > 3\n");
			DataStore
			         .o_list
	                 .stream()
	                 .filter(o->o.getProduct().getCategory().equals("GROCERY") && o.getQuantity()>3)
	                 .forEach(System.out::println);
			 System.out.println("===============================================\n");
		}
}
