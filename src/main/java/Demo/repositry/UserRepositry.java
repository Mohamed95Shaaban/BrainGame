package Demo.repositry;

import org.springframework.data.repository.CrudRepository;

import Demo.User.User;
public interface UserRepositry extends CrudRepository<User, Integer>{

	public User findByUserName(String userName);
	public User findByPassword(String password);
}
