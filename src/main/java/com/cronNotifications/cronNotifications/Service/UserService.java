package com.cronNotifications.cronNotifications.Service;

import com.cronNotifications.cronNotifications.Error.UserNotFoundException;
import com.cronNotifications.cronNotifications.Model.User;
import com.cronNotifications.cronNotifications.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> fetchAllUsers() throws UserNotFoundException;

   void sendDailyEmail();

    void sendMonthlyEmail();

    void sendWeeklyEmail();


}
