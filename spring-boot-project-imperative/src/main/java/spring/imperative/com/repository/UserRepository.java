package spring.imperative.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.imperative.com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

      public Optional<User> findByUsername(String username);
      public boolean existsByUsername(String username);

}
