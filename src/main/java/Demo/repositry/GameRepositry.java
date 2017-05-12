package Demo.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Demo.Course.Course;
import Demo.Game.Game;

public interface GameRepositry  extends CrudRepository<Game, Integer>{
	
	public List<Game> findByCourse(Course course);
	public Game findByGameName(String name);
	

}
