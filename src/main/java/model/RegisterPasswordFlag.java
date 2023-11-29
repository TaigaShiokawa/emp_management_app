package model;

public class RegisterPasswordFlag {
	public boolean flag;
	
	public RegisterPasswordFlag(String pass) {
		flag = pass.length() < 8;
	}
}