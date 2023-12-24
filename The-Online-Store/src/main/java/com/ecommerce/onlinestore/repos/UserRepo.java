package com.ecommerce.onlinestore.repos;

import com.ecommerce.onlinestore.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getByEmail(@Param("email") String email);

    User findByEmail(String email);
}
