package e_commerce_order_management;

/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class MappingService {

	public static void getProductNames(){
		// TODO Auto-generated method stub
		System.out.println("\n========== B1 ==========");
		System.out.println(" All Products Names : \n");
		DataStore
		         .o_list
		         .stream()
		         .map(o->o.getProduct().getName())
		         .forEach(System.out::println);
		System.out.println("==========================================");
	}
	public static void getOrderSummary() {
		// TODO Auto-generated method stub
		System.out.println("\n========== B2 ==========");
		System.out.println("All Orders details : \n");
		DataStore
		         .o_list
		         .stream()
		         .map(o->"OrderID#"+o.getOrderId()+" | "+o.getCustomer().getName()+" | Rs."+ o.getProduct().getPrice()+" | "+o.getStatus()
		         )
		         .forEach(System.out::println);
		        
		System.out.println("==========================================");
	}
	public static void getBookWithDiscount(){
		// TODO Auto-generated method stub
		System.out.println("\n========== B3 ==========");
		System.out.println("After applying 10% discount  : \n");
		
		DataStore		        
		         .p_list
		         .stream()
		         .map(p->{
		        	 if(p.getCategory().equals("BOOKS")){
		        		 return new Product(
		        				    p.getProductId(),
		                            p.getName(),
		                            p.getCategory(),
		                           
		                            p.getPrice()*(0.90),
		                            p.getStock()
		        				 );	 
		        	 }
		        	 return p;
		         })
		         .forEach(System.out::println);
		
		System.out.println("==========================================");
	}
	
	public static void getUniqueCity(){
		// TODO Auto-generated method stub
		System.out.println("\n========== B4 ==========");
		System.out.println("Uniue Cities  : \n");
		
		DataStore
		         .c_list
		         .stream()
		         .map(c->c.getCity())
		         .distinct()
		         .forEach(System.out::println);
		
		System.out.println("==========================================");
	}

}
