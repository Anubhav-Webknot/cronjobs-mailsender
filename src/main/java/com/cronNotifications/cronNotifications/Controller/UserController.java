package com.cronNotifications.cronNotifications.Controller;


import com.cronNotifications.cronNotifications.Error.UserNotFoundException;
import com.cronNotifications.cronNotifications.Model.User;
import com.cronNotifications.cronNotifications.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<User> saveUsers(@RequestBody User users)
    {
        return new ResponseEntity<>(userService.saveUser(users), HttpStatusCode.valueOf(200));

    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {

        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatusCode.valueOf(200));
    }


    public void sendDailyMail(){
        userService.sendDailyEmail();

    }

    public void sendMonthlyMail(){
        userService.sendMonthlyEmail();
    }

    public void sendWeeklyEmail(){
        userService.sendWeeklyEmail();

    }
}
