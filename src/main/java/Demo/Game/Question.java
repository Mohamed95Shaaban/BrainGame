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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="questions")
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="questionID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionID;
	
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "option1")
	private String option1;
	
	@Column(name = "option2")
	private String option2;
	
	
	@Column(name = "option3")
	private String option3;
	
	
	@ManyToOne
	@JoinColumn(name = "gameID")
	private Game game;
	
	
	
	
	
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	@JsonIgnore
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
	public Question() {
		
		
	}
	
	
	public Question(int questionID, String question, String answer, String option1, String option2, String option3,
			Game game) {
		
		this.questionID = questionID;
		this.question = question;
		this.answer = answer;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.game = game;
	}
	
	
	

	
}
