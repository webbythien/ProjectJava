
public class MyProduct {

	private String date;
	private int serial;
	private int price;
	
	public MyProduct(String d, int s,int p) {
		this.date = d;
		this.serial= s;
		this.price = p;
		
	}
	public void printDate() {
		System.out.println("Date: "+this.date);
	}
	public void printSerial() {
		System.out.println("Serial: "+this.serial);
	}
	public void printPrice() {
		System.out.println("Price : "+this.price);
	}
}
