package Demo.repositry;

import org.springframework.data.repository.CrudRepository;

import Demo.Playingrecord;

public interface PlayingRecordRepositry extends CrudRepository<Playingrecord, Integer> {

}
