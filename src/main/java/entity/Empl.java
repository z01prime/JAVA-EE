package entity;

public class Empl {
	private int id;
	private String name;
	private double salary;
	private int age;
	private String sex;
	private Dept dept;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Empl() {
		super();
	}
	public Empl(int id, String name, double salary, int age, String sex, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Empl [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", sex=" + sex + ", dept="
				+ dept + "]";
	}
	

}
