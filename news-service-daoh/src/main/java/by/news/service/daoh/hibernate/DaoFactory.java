package by.news.service.daoh.hibernate;


public enum DaoFactory implements Dao {
    USER_DAO {
        @Override
        public GenericDao getDao() {
            return new UserDaoImpl();
        }
    },
    NEWS_DAO {
        @Override
        public GenericDao getDao() {
            return new NewsDaoImpl();
        }
    },
    ROLE_DAO {
        @Override
        public GenericDao getDao() {
            return new RoleDaoImpl();
        }
    }
}
