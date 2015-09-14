package by.news.service.daojpa.repository.interf;


import by.news.service.daojpa.pojos.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer>{
}
