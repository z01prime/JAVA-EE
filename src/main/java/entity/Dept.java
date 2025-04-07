package entity;

public class Dept {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dept(int id) {
		super();
		this.id = id;
		
	}
	public Dept() {
		super();
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}
	

}
