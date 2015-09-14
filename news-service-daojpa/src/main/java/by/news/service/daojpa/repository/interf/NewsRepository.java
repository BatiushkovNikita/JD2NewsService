package by.news.service.daojpa.repository.interf;


import by.news.service.daojpa.pojos.News;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface NewsRepository extends CrudRepository<News, Integer>{

}
