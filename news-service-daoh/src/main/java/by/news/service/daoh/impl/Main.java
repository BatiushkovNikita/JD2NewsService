package by.news.service.daoh.impl;

import by.news.service.daoh.interf.BaseDao;
import by.news.service.daoh.pojos.Role;
import by.news.service.daoh.pojos.User;
import by.news.service.daoh.util.JpaUtil;
import by.news.service.vo.NewsVO;
import by.news.service.vo.RoleVO;
import by.news.service.vo.UserVO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static EntityManager entityManager = JpaUtil.INSTANCE.getEntityManager();

    public static void main(String[] args) {
        userTest();
        userTest();
        //newsTest();
        //getUserRoles(2);
        System.out.println(geUser(6));


    }

    private static UserVO geUser(int id) {
        BaseDao<UserVO, Integer> userDao = new UserDao();
        userDao.setEntityManager(entityManager);
        return userDao.getByPK(id);
    }

    public static void getUserRoles(int userId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, userId);
        transaction.commit();

        for (Role role : user.getRoles()) {
            System.out.println(role);
        }
    }


    public static void newsTest() {
        NewsVO newsVO = new NewsVO();
        newsVO.setNewsText("dskdlskldksl");
        newsVO.setPublicationDate(getCurrentDate());
        newsVO.setTopic("NEws topic for user #10");
        newsVO.setUserId(1);

        BaseDao<NewsVO, Integer> newsDao = new NewsDao();
        newsDao.setEntityManager(entityManager);
        newsDao.create(newsVO);

    }

    public static void userTest() {
        UserVO userVO = new UserVO();
        userVO.setEmail("tryr@rureu");
        userVO.setPassword("oeoeoeoeoe");
        userVO.setFirstName("Nikita");
        userVO.setLastName("Batsiushkov");
        userVO.setCellPhone("6234981");

/*        RoleVO roleVO = new RoleVO();
        roleVO.setId(3);
        roleVO.setRoleName("user");
        Set<RoleVO> rolesVO = new HashSet<>();
        rolesVO.add(roleVO);
        userVO.setRoles(rolesVO);*/

        BaseDao<UserVO, Integer> userDao = new UserDao();
        userDao.setEntityManager(entityManager);
        userDao.create(userVO);
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
