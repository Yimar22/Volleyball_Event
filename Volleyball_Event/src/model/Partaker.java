package model;

public class Partaker implements Comparable<Partaker>{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo; 
	private String birthday;
	private Partaker left;
	private Partaker rigth;
	private Partaker next;
	private Partaker prev;
	
	
	public Partaker(int id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Partaker getLeft() {
		return left;
	}


	public void setLeft(Partaker left) {
		this.left = left;
	}


	public Partaker getRigth() {
		return rigth;
	}


	public void setRigth(Partaker rigth) {
		this.rigth = rigth;
	}


	public Partaker getNext() {
		return next;
	}


	public void setNext(Partaker next) {
		this.next = next;
	}


	public Partaker getPrev() {
		return prev;
	}


	public void setPrev(Partaker prev) {
		this.prev = prev;
	}


	public int compareTo(Partaker p) {
		int comparation;
		
		if(id<p.id) {
			comparation = -1;
		}else if(id>p.id) {
			comparation =1;
		}else {
			comparation = 0;
		}
		
		return comparation;
	}
}