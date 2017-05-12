package Demo.Game;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.User.User;
import Demo.repositry.CommentRepositry;
import Demo.repositry.GameRepositry;
import Demo.repositry.UserRepositry;

@RestController
public class CommentRestController {

	@Autowired
		UserRepositry userRep;
	
	@Autowired
	  GameRepositry GameRep;
	
	@Autowired
	 	CommentRepositry CommentRep;
	
	
	@RequestMapping( value="/addcomment/{gameID}/{userID}",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> addComment(@PathVariable ("gameID") int gameID, @PathVariable("userID")int userID, @RequestBody Comment comment)
	{
		Map<String,String> data = new HashMap<>();
		User user = userRep.findOne(userID);
		Game game = GameRep.findOne(gameID);
		if (user == null || game == null)
			data.put("check", "false");
		else
		{
			comment.setUserID(user);
			comment.setGameID(game);
			CommentRep.save(comment);
			data.put("check", "true");
		}
			
		return data;
	}
	
}
