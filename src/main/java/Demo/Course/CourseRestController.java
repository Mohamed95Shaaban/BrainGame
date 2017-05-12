package Demo.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.Game.Game;
import Demo.User.User;
import Demo.repositry.CourseRepositry;
import Demo.repositry.GameRepositry;
import Demo.repositry.UserRepositry;
@RestController
public class CourseRestController {

	@Autowired
		GameRepositry gameRep;
		
	@Autowired
		CourseRepositry courseRep;
		

	@Autowired
	 UserRepositry userRep;
	
	
	
	
	@RequestMapping("/games")
	public List<Game> retrieveAllGames(@RequestParam("coursID") int id)
	{
		Course course = courseRep.findOne(id);
		List<Game> games =new ArrayList<>();
		if(course!=null)
		{
			games =  gameRep.findByCourse(course);
		}
		return games;
	}
	
	
	
	@RequestMapping("/courses")
	public List<Course> rerieveAllCourses()
	{
		
		return (List<Course>) courseRep.findAll();
	}
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/addcourse/{teacherId}")
	public @ResponseBody Map<String,String> createCourse(@RequestBody Course course, @PathVariable int teacherId) 
	{
		System.out.println(teacherId);
		Map<String,String> data = new HashMap<>();
		User  Teacher = userRep.findOne(teacherId);
		System.out.println(Teacher.getTeacherCode());
		if(Teacher.getTeacherCode().equals("TA123"))
		{
			course.setUser(Teacher);
			courseRep.save(course);
			data.put("check", "true");
			Course course2 = courseRep.findByCourseName(course.getCourseName());
			data.put("ID", course2.getCourseID()+"");
			
			return data;
			
		}
		
		data.put("check", "false");
		return data;
	}
}
