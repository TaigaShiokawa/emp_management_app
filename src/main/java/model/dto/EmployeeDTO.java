package model.dto;

public class EmployeeDTO {
	
	private int id;
	private String name;
	private String password;
	private int department;
	private int post;
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(int id, String name, String password, int department, int post) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.department = department;
		this.post = post;
	}
	public EmployeeDTO(int id, String name, int department, int post) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.post = post;
	}
	public EmployeeDTO(String name, int department, int post) {
		this.name = name;
		this.department = department;
		this.post = post;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}
}
