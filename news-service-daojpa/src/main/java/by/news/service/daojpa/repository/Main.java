package by.news.service.daojpa.repository;


public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.findUser(1);
    }
}
