package Demo.Game;

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

import Demo.Playingrecord;
import Demo.Course.Course;

@Entity
@Table(name = "game")
public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "gameID")
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int gameID ; 
	
	
	


	@Column(name = "gameName")
	private String gameName;
	
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "rate", nullable=true)
	private float rate;
	
	@Column(name = "type")
	private String type;
	
	
	@ManyToOne
	@JoinColumn(name = "courseID")
	private Course	course;
	
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Playingrecord> playingRecords ;
    
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Question> questions;
	
	
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Comment> comments;
    
	@Column(name = "teacherID")
	private int techerID;
	
    public Game() {
		
	}
    
	
	public int getTecherID() {
		return techerID;
	}


	public void setTecherID(int techerID) {
		this.techerID = techerID;
	}


	public Game(int gameID, String gameName, String description, float rate, String type, Course course
			) {
		this.gameID = gameID;
		this.gameName = gameName;
		this.description = description;
		this.rate = rate;
		this.type = type;
		this.course = course;
		
	}
	public Game( String gameName, String description, float rate, String type, Course course
			) {
		this.gameName = gameName;
		this.description = description;
		this.rate = rate;
		this.type = type;
		this.course = course;
		
	}

	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	@JsonIgnore
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	@JsonIgnore
	public Set<Playingrecord> getPlayingRecords() {
		return playingRecords;
	}


	public void setPlayingRecords(Set<Playingrecord> playingRecords) {
		this.playingRecords = playingRecords;
	}

	@JsonIgnore
	public Set<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@JsonIgnore 
	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
    

}
