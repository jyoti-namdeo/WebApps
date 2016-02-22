class Product{
	int id;
	String name;
	String des;
	long price;
	
	
	
	
	public Product(int id1, String name1, String des1, long p1){
		id = id1;
		name = name1;
		des = des1;
		price = p1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}