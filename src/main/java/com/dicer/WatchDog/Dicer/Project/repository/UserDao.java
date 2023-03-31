package com.dicer.WatchDog.Dicer.Project.repository;

import com.dicer.WatchDog.Dicer.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByTaxpayernumber(String taxpayernumber);

    /**
     * Faz a mesma coisa que o spring data, porém de forma simplificada
     */
    @Query("select u from User u where u.taxpayernumber = :taxpayernumber")
    User findBy(String taxpayernumber);
}
