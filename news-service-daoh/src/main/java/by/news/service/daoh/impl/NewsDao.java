package by.news.service.daoh.impl;


import by.news.service.daoh.exception.DaoException;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.News;
import by.news.service.daoh.util.JpaUtil;
import by.news.service.vo.NewsVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;

public class NewsDao implements BaseDao<NewsVO, Integer>{

    private Logger Log = LogManager.getLogger(UserDao.class.getName());
    private EntityManager entityManager;


    public EntityManager getEntityManager() {
        if (entityManager == null) {
            Log.error("Cannot configured DAO. EntityManager is not submitted.");
            throw new DaoException("Cannot configured DAO. EntityManager is not submitted.");
        }
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Integer create(NewsVO newsVO) throws DaoException {
        Log.info("Creating news");
        Log.debug("Preparing data");
        News news = extractNews(newsVO);
        EntityTransaction transaction = null;
        try {
            Log.debug("Getting transaction");
            transaction = getEntityManager().getTransaction();
            Log.debug("Beginning transaction");
            transaction.begin();


            Log.debug("Persisting News");
            entityManager.persist(news);


            Log.debug("Committing transaction");
            transaction.commit();
        } catch (PersistenceException e) {
            Log.error("Cannot complete transaction ", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot complete transaction ", e);
        } finally {
            JpaUtil.INSTANCE.closeResources(entityManager);
        }
        return news.getId();
    }

    @Override
    public NewsVO getByPK(Integer key) throws DaoException {
        return null;
    }

    @Override
    public boolean update(NewsVO newsVO) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Integer key) throws DaoException {
        return false;
    }

    @Override
    public List<NewsVO> getAll() throws DaoException {
        return null;
    }

    private News extractNews(NewsVO newsVO) {
        News news = new News();
        news.setTopic(newsVO.getTopic());
        news.setNewsText(newsVO.getNewsText());
        news.setPublicationDate(newsVO.getPublicationDate());
        news.setUserId(newsVO.getUserId());
        return news;
    }
}
