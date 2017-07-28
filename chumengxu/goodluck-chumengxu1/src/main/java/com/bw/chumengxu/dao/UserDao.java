package com.bw.chumengxu.dao;

import com.bw.chumengxu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sliyan on 2017/7/28.
 */
public interface UserDao extends JpaRepository<User,Integer>{


    User findByUsername(String username);

    User findById(Integer id);
}
