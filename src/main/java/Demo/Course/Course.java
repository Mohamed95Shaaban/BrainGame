package Demo.Course;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Demo.Game.Game;
import Demo.User.User;
@Entity
@Table(name = "course")
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "coursID")
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int  CourseID;
	
	@Column(name = "courseName")
    private String	courseName;
	
	@Column(name = "description")
    private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "userID")
    private User user;
    
    
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<Game> games;
	
	
    public Course() {
		
		
	}
    
    
    
	public Course(int courseID, String courseName, String description, User user) {
		
		CourseID = courseID;
		this.courseName = courseName;
		this.description = description;
		this.user = user;
	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	@JsonIgnore
	public Set<Game> getGames() {
		return games;
	}



	public void setGames(Set<Game> games) {
		this.games = games;
	}
    
	

	
}
