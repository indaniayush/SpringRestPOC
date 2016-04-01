package spring.rest.model;


public class User {
	
	protected String customerID;
	protected String title;
	protected String fName;
	protected String lName;
	protected String addr1;
	protected String addr2;
	protected long phone;
	protected int age;
	protected String city;
	protected String state;
	protected String country;
	protected String email;
	protected int pincode;
	protected String password;
	

	public User(){
		
	}	
	
	public User(String customerID, String title, String fName, String lName,
			String addr1, String addr2, Long phone, Integer age,
			String city, String state, String country, String email,
			Integer pincode, String password) {
		super();
		this.customerID = customerID;
		this.title = title;
		this.fName = fName;
		this.lName = lName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.age = age;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pincode = pincode;
		this.password = password;
	}



	public String getcustomerID() {
		return customerID;
	}
	public void setcustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
