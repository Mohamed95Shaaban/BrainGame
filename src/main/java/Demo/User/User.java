package Demo.User;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Demo.Playingrecord;
import Demo.Course.Course;
import Demo.Game.Comment;

@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "userID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int userID;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "teacherCode")
	private String teacherCode;
	
	@Column (name= "password")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Course> courses;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Playingrecord> playingRecords;
	
	
	public User() {
	
		
	}
	
	
	public User( String userName, String name, int age, char gender, String type, String mail,
			 String password) {
	
		this.userName = userName;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
		this.mail = mail;
		this.password = password;
	}
	
	
   public User(int userID, String userName, String name, int age, char gender, String type, String mail,
			String teacherCode, String password) {
	
		this.userID = userID;
		this.userName = userName;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
		this.mail = mail;
		this.teacherCode = teacherCode;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	
	
}
