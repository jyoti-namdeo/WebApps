
import java.util.ArrayList;

public class CartOperations {
	public static ArrayList<ShoppingCartServlet> cartAL = new ArrayList<>();
	public static void addToCart(ShoppingCartServlet cart){
		cartAL.add(cart);
	}
	public static void removeFromCart(int position){
		cartAL.remove(position);
	}
	public static void updateCart(int cartID, int quantity){
		ShoppingCartServlet temp = cartAL.get(cartID);
		temp.setQuantity(quantity);
		int newPrice = (int) (temp.getPrice()*quantity);
		temp.setPrice(newPrice);
		
	}
	public static ArrayList<ShoppingCartServlet> fetchCart(){
		return cartAL;
	}
	
}
