package com.dicer.WatchDog.Dicer.Project.repository;

import com.dicer.WatchDog.Dicer.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

//    @Query("select * from ")
}
