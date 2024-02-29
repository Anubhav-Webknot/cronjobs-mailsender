package com.cronNotifications.cronNotifications;

import com.cronNotifications.cronNotifications.Service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CronNotificationsApplication {



	public static void main(String[] args) {
		SpringApplication.run(CronNotificationsApplication.class, args);
	}

}
