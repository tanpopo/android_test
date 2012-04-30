package mytest.list;

public class MyStock {
	private int id;
	private String name;

	public MyStock(int i, String n) {
		id = i;
		name = n;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int i) {
		id = i;
	}
	public void setName(String n) {
		name = n;
	}
//	public String toString() {
//		return name;
//	}
}
