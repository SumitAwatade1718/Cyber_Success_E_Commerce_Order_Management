package e_commerce_order_management;

/**
 * Author: Sumit Vilas Awatade
 * Date: 20-Jun-2026
 */
public class PrintService {
	// D1. Print all order details
		public static void printAllOrders() {

			System.out.println("\n========== D1 ==========");
			System.out.printf("%-8s %-20s %-20s %-12s %-12s%n",
					"OrderID", "Customer", "Product", "Amount", "Status");
			System.out.println("--------------------------------------------------------------------------");

			DataStore
					.o_list
					.forEach(o->System.out.printf("%-8d %-20s %-20s %-12.2f %-12s%n",
							o.getOrderId(),
							o.getCustomer().getName(),
							o.getProduct().getName(),
							o.getTotalAmount(),
							o.getStatus()));

			System.out.println("==========================================================================");
		}
		
		// D2. Thank You Message
		public static void thankYouMessage(){

			System.out.println("\n========== D2 ==========");
            DataStore
                     .o_list
                     .stream()
                     .filter(o->o.getStatus().equals("DELIVERED"))
                     .forEach(o->System.out.println("Thank You, "+o.getCustomer().getName()+" For Purching "+o.getProduct().getName())
                    	 
                     );
			

			System.out.println("=======================================================");
		}
		// D3. Update Stock
		public static void updateStock(){
			System.out.println("\n========== D3 ==========");

			DataStore
					.o_list
					.forEach(o->{
						int remaining = o.getProduct().getStock() - o.getQuantity();
						System.out.printf(
					            "%-17s | Stock Before: %-5d | Remaining Stock: %-5d%n",
					            o.getProduct().getName(),
					            o.getProduct().getStock(),
					            remaining);
					});
			System.out.println("=============================================================");
		}
		public static void categoryWiseProducts(){

		    System.out.println("\n========== D4 ==========");

		    System.out.println("\nELECTRONICS : ");
		    DataStore.p_list.stream()
		            .filter(p->p.getCategory().equals("ELECTRONICS"))
		            .forEach(o->System.out.println(o.getName()));
		    System.out.println("-------------------");
		    System.out.println("\nCLOTHING : ");
		    DataStore.p_list.stream()
		            .filter(p->p.getCategory().equals("CLOTHING"))
		            .forEach(o->System.out.println(o.getName()));
		    System.out.println("-------------------");
		    System.out.println("\nGROCERY : ");
		    DataStore.p_list.stream()
		            .filter(p->p.getCategory().equals("GROCERY"))
		            .forEach(o->System.out.println(o.getName()));
		    System.out.println("-------------------");
		    System.out.println("\nBOOKS : ");
		    DataStore.p_list.stream()
		            .filter(p->p.getCategory().equals("BOOKS"))
		            .forEach(o->System.out.println(o.getName()));
		    System.out.println("-------------------");
		    
		}
		// D5. Print Top 3 Highest Value Orders
		public static void topThreeOrders(){

		    System.out.println("\n========== D5 ==========");
		    System.out.println("Top 3 Highest Value Orders\n");
		    DataStore
		            .o_list
		            .stream()
		            .sorted((o1,o2)->Double.compare(o2.getTotalAmount(),o1.getTotalAmount()))
		            .limit(3)
		            .forEach(System.out::println);
		    System.out.println("===============================================");
		}
		

}
