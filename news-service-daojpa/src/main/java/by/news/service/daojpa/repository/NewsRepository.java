package by.news.service.daojpa.repository;


import by.news.service.daojpa.pojos.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Integer>{

}
