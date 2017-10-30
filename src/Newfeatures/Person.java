package Newfeatures;

public class Person {
	private int Id;
	private String Name;
	private int Age;
	private double Salary;
	public Person(){
	}
	public Person(int id, String name, int age, double salary) {
		this.Id = id;
		this.Name = name;
		this.Age = age;
		this.Salary = salary;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Person [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Salary=" + Salary + "]";
	}
	
}
