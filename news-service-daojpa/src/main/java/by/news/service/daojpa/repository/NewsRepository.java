package by.news.service.daojpa.repository;


import by.news.service.daojpa.pojos.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{

}
