package by.news.service.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String t="123";
        String encode = bCryptPasswordEncoder.encode(t);
        System.out.println(encode);

        String encode2 = bCryptPasswordEncoder.encode(t);
        System.out.println(encode2);

        boolean matches = bCryptPasswordEncoder.matches("123", encode2);
        System.out.println(matches);

        //System.out.println(bCryptPasswordEncoder.encode(encode));

    }
}
