package by.news.service.daoh.hibernate;


import by.news.service.daoh.pojos.News;

public class NewsDaoImpl extends AbstractDao<News, Integer> {

    @Override
    protected Class getPersistentClass() {
        return News.class;
    }
}
