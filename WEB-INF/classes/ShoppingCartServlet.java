
class ShoppingCartServlet {
	int product_ID,quantity;
	long price;
	String productName;
	
	public ShoppingCartServlet(int product_ID, String productName, long price, int quantity) {
		super();
		this.product_ID = product_ID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
