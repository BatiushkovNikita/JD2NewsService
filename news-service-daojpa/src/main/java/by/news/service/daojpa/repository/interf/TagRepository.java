package by.news.service.daojpa.repository.interf;

import by.news.service.daojpa.pojos.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Integer>{

    @Query("select t.newses from Tag t where t.tagName = ?1")
    List findByTag(String tagName);
}
