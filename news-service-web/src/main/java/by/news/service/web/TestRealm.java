package by.news.service.web;


import org.apache.catalina.Realm;
import org.apache.catalina.realm.JDBCRealm;
import org.apache.catalina.realm.RealmBase;

public class TestRealm {
    public static void main(String[] args) {
        Realm realm = new JDBCRealm();
        realm.authenticate("Nikita", "12345");
    }
}
