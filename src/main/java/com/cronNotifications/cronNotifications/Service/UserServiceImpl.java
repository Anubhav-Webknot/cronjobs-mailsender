package com.cronNotifications.cronNotifications.Service;

import com.cronNotifications.cronNotifications.Error.UserNotFoundException;
import com.cronNotifications.cronNotifications.Model.EmailFrequency;
import com.cronNotifications.cronNotifications.Model.User;
import com.cronNotifications.cronNotifications.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String receiver, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("anubhavonnet01@gmail.com");
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        log.info("Mail sent successfully to "+receiver);
    }

    @Scheduled(cron ="0 30 18 1 * *")
    public void sendMonthlyEmail() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getEmailFrequency() == EmailFrequency.MONTHLY) {
                String subject = "Monthly Reminder";
                String body = "Here is your Monthly Reminder for Stand up call";
                sendEmail(user.getEmail(), subject, body);

            }
        }
    }
    @Scheduled(cron ="0 30 18 * * 1")
    public void sendWeeklyEmail() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmailFrequency() == EmailFrequency.WEEKLY) {
                String subject = "Weekly Reminder";
                String body = "Here is your Weekly Reminder for Major Assignment Submission";
                sendEmail(user.getEmail(), subject, body);
            }
        }
    }
    @Scheduled(cron = "0 52 18 * * *")
    public void sendDailyEmail() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmailFrequency() == EmailFrequency.DAILY) {
                String subject = "Daily Reminder";
                String body = "Here is your daily Reminder for Sync up call";
                sendEmail(user.getEmail(), subject, body);
            }
        }
    }


    @Override
    public User saveUser(User user)throws IllegalArgumentException {
        if (user == null) {
            throw new IllegalArgumentException("Blog cannot be null");
        }
        return userRepository.save(user);
    }

    @Override

    public List<User> fetchAllUsers() throws UserNotFoundException {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()) {
            throw new UserNotFoundException("No blogs found");
        }
        return allUsers;
    }



}
