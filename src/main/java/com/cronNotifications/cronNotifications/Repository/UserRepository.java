package com.cronNotifications.cronNotifications.Repository;


import com.cronNotifications.cronNotifications.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
