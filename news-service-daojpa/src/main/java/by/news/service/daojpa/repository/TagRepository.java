package by.news.service.daojpa.repository;

import by.news.service.daojpa.pojos.News;
import by.news.service.daojpa.pojos.Tag;
import by.news.service.vo.NewsVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{

    @Query("select t.newses from Tag t where t.tagName = ?1")
    List findByTag(String tagName);
}
