package zsk.newIdea;

import java.util.Arrays;

public class ListTest {
	private String[] name;
	private int[] id;
	private String[] custmer;
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getId() {
		return id;
	}
	public void setId(int[] id) {
		this.id = id;
	}
	public String[] getCustmer() {
		return custmer;
	}
	public void setCustmer(String[] custmer) {
		this.custmer = custmer;
	}
	@Override
	public String toString() {
		return "ListTest [name=" + Arrays.toString(name) + ", id=" + Arrays.toString(id) + ", custmer="
				+ Arrays.toString(custmer) + "]";
	}
	
}
