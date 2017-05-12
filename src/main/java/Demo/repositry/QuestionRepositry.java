package Demo.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Demo.Game.Game;
import Demo.Game.Question;

public interface QuestionRepositry extends CrudRepository<Question, Integer> {

	public List<Question> findByGame(Game game);
}
