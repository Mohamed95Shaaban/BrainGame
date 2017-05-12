package Demo.repositry;

import org.springframework.data.repository.CrudRepository;

import Demo.Course.Course;

public interface CourseRepositry extends CrudRepository<Course, Integer>{

	public Course findByCourseName(String name);
}
