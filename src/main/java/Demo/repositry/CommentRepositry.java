package Demo.repositry;

import org.springframework.data.repository.CrudRepository;

import Demo.Game.Comment;

public interface CommentRepositry extends CrudRepository<Comment, Integer>{

}
