package com.greet.service;

import com.greet.model.User;
import com.greet.repository.UserRepository;
import com.greet.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {

        System.out.println("======================================");
        System.out.println("Username Entered : " + username);

        User user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User NOT FOUND in database.");
            System.out.println("======================================");
            return null;
        }

        System.out.println("Database Username : " + user.getUsername());
        System.out.println("Database Password : " + user.getPassword());

        String hashedPassword = HashUtil.hashPassword(password);

        System.out.println("Entered Password Hash : " + hashedPassword);

        if (hashedPassword.equals(user.getPassword())) {
            System.out.println("LOGIN SUCCESS");
            System.out.println("======================================");
            return user;
        }

        System.out.println("PASSWORD MISMATCH");
        System.out.println("======================================");

        return null;
    }

    @Override
    public boolean register(User user) {

        User existing = userRepository.findByUsername(user.getUsername());

        if (existing != null) {
            return false;
        }

        user.setPassword(HashUtil.hashPassword(user.getPassword()));

        return userRepository.save(user);
    }
}


//package com.greet.service;
//
//import com.greet.model.User;
//import com.greet.repository.UserRepository;
//import com.greet.util.HashUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User login(String username,
//                      String password) {
//
//        User user =
//                userRepository.findByUsername(username);
//
//        if (user == null) {
//            return null;
//        }
//
//        String hashedPassword =
//                HashUtil.hashPassword(password);
//
//        if (hashedPassword.equals(user.getPassword())) {
//            return user;
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean register(User user) {
//
//        User existing =
//                userRepository.findByUsername(
//                        user.getUsername()
//                );
//
//        if (existing != null) {
//            return false;
//        }
//
//        user.setPassword(
//                HashUtil.hashPassword(
//                        user.getPassword()
//                )
//        );
//
//        return userRepository.save(user);
//    }
//}
