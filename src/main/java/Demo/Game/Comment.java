package Demo.Game;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Demo.User.User;

@Entity
@Table (name = "comment")
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name = "commentID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int commentID;
	
	@Column(name ="text")
	private String text;
	
	@Column(name = "date")
	private int date;
	
	
    @ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	
	@ManyToOne
	@JoinColumn( name= "gameID")
	private Game game;
	
	
	
	
	public Comment() {
		
	}
	
	
	
	
	
	public Comment(int commentID, String text, int date, User user, Game game) {
		this.commentID = commentID;
		this.text = text;
		this.date = date;
		this.user = user;
		this.game = game;
	}
	
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUserID(User user) {
		this.user = user;
	}
	public Game getGame() {
		return game;
	}
	public void setGameID(Game game) {
		this.game = game;
	}
	
	
	

	
}
