package Demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import Demo.Game.Game;
import Demo.User.User;
@Entity
@Table(name="playingrecord")
public class Playingrecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "recordID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordID;
	
    @Column(name="score")	
	private int score;
    
    @Column(name="nextquestio")
	private int nextquestion;
    
    @ManyToOne
    @JoinColumn(name = "userID")
	private User user;

    @ManyToOne
    @JoinColumn(name = "gameID")
    private Game game;
    
    @Column(name = "rate")
    @Null
	private int rate;
	
	
	
    
    
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNextquestion() {
		return nextquestion;
	}
	public void setNextquestion(int nextquestion) {
		this.nextquestion = nextquestion;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	
	
	public Playingrecord() {
		
	}
	public Playingrecord(int recordID, int score, int nextquestion, User user, Game game, int rate) {
		super();
		this.recordID = recordID;
		this.score = score;
		this.nextquestion = nextquestion;
		this.user = user;
		this.game = game;
		this.rate = rate;
	}
	
	
	
	
	
	
	
	
	
}
