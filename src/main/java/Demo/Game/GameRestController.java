package Demo.Game;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.Course.Course;
import Demo.User.User;
import Demo.repositry.CourseRepositry;
import Demo.repositry.GameRepositry;
import Demo.repositry.QuestionRepositry;
import Demo.repositry.UserRepositry;

@RestController
public class GameRestController {

	@Autowired
	  GameRepositry gameRep;
	
	@Autowired
	  CourseRepositry courseRep;
	
	@Autowired
	 UserRepositry userRep;
	
	@Autowired
	  QuestionRepositry questionRep;
	
	
		@RequestMapping( value="/playgame/{gameID}" ,method=RequestMethod.POST)
		public @ResponseBody List<Question> playGame(@PathVariable("gameID")  int gameID)
		{
			if(gameRep.findOne(gameID)!= null)
			{
				return questionRep.findByGame(gameRep.findOne(gameID));
			}
			
		 return Collections.emptyList();
		}
		
		
		
		
		@RequestMapping(value="/addgame/{courseID}" ,method=RequestMethod.POST)
		 public @ResponseBody Map<String, String> createGame(@PathVariable("courseID") int courseID, @RequestBody Game game)
		 {
			Map<String,String> data = new HashMap<>();

			User Teacher =  userRep.findOne(game.getTecherID());
			if(Teacher.getTeacherCode().equals("TA123"))
			{
				Course course = courseRep.findOne(courseID);
				if(course != null)
				{
					game.setCourse(course);
					gameRep.save(game);
					Game game2 = gameRep.findByGameName(game.getGameName());
					data.put("ID", game2.getGameID()+"");
					data.put("check", "true");
					return data;
					
				}
				
			
			}
			data.put("check", "false");
			return data;
			
		 }
		
		
		@RequestMapping (value = "/addquestions/{gameID}", method = RequestMethod.POST )
		 public @ResponseBody Map<String, String> addquestions(@PathVariable int gameID, @RequestBody List<Question> questions )
		 {
			Map<String,String> data = new HashMap<>();
			
			 Game game = gameRep.findOne(gameID);
			 
			 if(game != null)
			 {
				for (Question question : questions) 
				{
					question.setGame(game);
					questionRep.save(question);
				}
				data.put("check", "true");
				return data;
			 }
			
			data.put("check", "false"); 
			return data;
		 }
		
		
		@RequestMapping ("/copygame/{gameID}/{teacherID}" )
		public @ResponseBody Map<String, String> copyGame(@PathVariable int gameID, @PathVariable int teacherID)
		{
			Map<String,String> data = new HashMap<>();
			
			Game game = gameRep.findOne(gameID);
			User Teacher = userRep.findOne(teacherID);
			if(gameRep.findOne(gameID) == null || userRep.findOne(teacherID) == null || !Teacher.getTeacherCode().equals("TA123"))
				data.put("check", "false");
			else
			{
				Game Ngame= new Game(game.getGameName(), game.getDescription(), game.getRate(), game.getType(), game.getCourse());
				Ngame.setTecherID(teacherID);
				gameRep.save(Ngame);
				data.put("check", "true");
			}
			return data;
		}
}
