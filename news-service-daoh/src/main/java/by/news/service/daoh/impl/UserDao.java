package by.news.service.daoh.impl;

import by.news.service.daoh.exception.DaoException;
import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.Role;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.pojos.UserDetail;
import by.news.service.daoh.util.JpaUtil;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDao implements BaseDao<UserVO, Integer> {

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
    public Integer create(UserVO userVO) throws DaoException {
        Log.info("Creating user");
        Log.debug("Preparing data");
        User user = extractUser(userVO);
        UserDetail userDetail = extractUserDetail(userVO);
        EntityTransaction transaction = null;
        try {
            Log.debug("Getting transaction");
            transaction = getEntityManager().getTransaction();
            Log.debug("Beginning transaction");
            transaction.begin();
            Log.debug("Persisting UserDetails");
            getEntityManager().persist(userDetail);
            user.setUserDetail(userDetail);
            Log.debug("Persisting User");
            getEntityManager().persist(user);
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
        return user.getId();
    }

    @Override
    public UserVO getByPK(Integer key) throws DaoException {
        Log.info("Getting user by key: " + key);
        Log.debug("Preparing data");
        UserVO userVO = null;
        EntityTransaction transaction = null;
        try {
            Log.debug("Getting transaction");
            transaction = getEntityManager().getTransaction();
            Log.debug("Beginning transaction");
            transaction.begin();
            Log.debug("Finding user by key");
            User user = getEntityManager().find(User.class, key);
            Log.debug("Composing data for returning");
            userVO = composeUser(user);
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
        Log.info("Returning UserVO");
        return userVO;
    }



    @Override
    public boolean update(UserVO object) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Integer key) throws DaoException {
        return false;
    }

    @Override
    public List<UserVO> getAll() throws DaoException {
        return null;
    }

    private User extractUser(UserVO userVO) {
        User user = new User();
        user.setEmail(userVO.getEmail());
        user.setPassword(userVO.getPassword());
        Set<RoleVO> rolesVO = userVO.getRoles();
        user.setRoles(extractRoles(rolesVO));
        return user;
    }

    private UserDetail extractUserDetail(UserVO userVO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName(userVO.getFirstName());
        userDetail.setLastName(userVO.getLastName());
        userDetail.setCellPhone(userVO.getCellPhone());
        return userDetail;
    }

    private UserVO composeUser(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setEmail(user.getEmail());
        userVO.setPassword(null);
        userVO.setFirstName(user.getUserDetail().getFirstName());
        userVO.setLastName(user.getUserDetail().getFirstName());
        userVO.setCellPhone(user.getUserDetail().getCellPhone());
        userVO.setRoles(composeRole(user.getRoles()));
        return userVO;
    }

    private Set<RoleVO> composeRole(Set<Role> roles) {
        Set<RoleVO> rolesVO = new HashSet<>();
        for (Role role : roles) {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(role.getId());
            roleVO.setRoleName(role.getRoleName());
            rolesVO.add(roleVO);
        }
        return rolesVO;
    }

    private Set<Role> extractRoles(Set<RoleVO> rolesVO) {
        Set<Role> roles = new HashSet<>();
        for (RoleVO roleVO : rolesVO) {
            Role role = new Role();
            role.setId(roleVO.getId());
            role.setRoleName(roleVO.getRoleName());
            roles.add(role);
        }
        return roles;
    }
}
