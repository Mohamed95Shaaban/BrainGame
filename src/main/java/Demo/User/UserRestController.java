package Demo.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.repositry.UserRepositry;

@RestController
public class UserRestController {

  @Autowired
   UserRepositry userRep;
 
 
  
  
  
  @RequestMapping(value = "/login" , method = RequestMethod.POST )
  public @ResponseBody Map<String,String> verifylogin(@RequestBody Map<String, String> logIn)
  {
	   Map<String,String> data = new HashMap<>();
	   
	   User user1 = userRep.findByUserName(logIn.get("userName"));
	   User user2 = userRep.findByPassword(logIn.get("password"));
	   if(user1.equals(user2) && user1!=null)
	   {
		   data.put("check", "true");
		   if(user1.getType().equals("Teacher") && user1.getTeacherCode().equals("TA123"))
		   {
			  data.put("type", user1.getType());
			  data.put("userID", user1.getUserID()+"");
			  data.put("userName", user1.getUserName());
			  data.put("name", user1.getName());
			  data.put("age", user1.getAge()+"");
			  data.put("gender",user1.getGender()+"");
			  data.put("mail", user1.getMail());
			  data.put("password", user1.getPassword());
			  return data;
		   }
	   }
	   data.put("check", "false");
	   return data;	
  }
   
  
  @RequestMapping( value="/signup",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> creatUser(@RequestBody User user)
	{
		Map<String, String> data= new HashMap<String, String>();
		if(userRep.findByUserName(user.getUserName())== null)
			{
			
			userRep.save(user);
		   User user1= userRep.findByUserName(user.getUserName());
		     
		     data.put("check", "true");
		     data.put("ID", user1.getUserID()+"");
			return data;
			
			}
		
		    data.put("check", "false");
			return data;
	}
  
 
}
