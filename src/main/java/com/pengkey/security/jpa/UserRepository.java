package com.pengkey.security.jpa;

import com.pengkey.security.domain.JpaUser;
import com.pengkey.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<JpaUser,Long>{
    JpaUser findByName(String name);

    JpaUser findByNameAndAge(String name, Integer age);

    @Query("from JpaUser u where u.name=:name")
    JpaUser findUser(@Param("name") String name);
}
