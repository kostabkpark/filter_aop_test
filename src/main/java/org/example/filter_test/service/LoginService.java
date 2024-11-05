package org.example.filter_test.service;

import org.example.filter_test.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {

    public boolean isLoginSuceess(User user) {
        if (user != null &&
                StringUtils.hasText(user.getUserId()) &&
                StringUtils.hasText(user.getPassword())) {
            if(user.getUserId().equals("aaa") && user.getPassword().equals("1111")) {
                return true;
            }
            return false;
        }
        return false;
    }
}
