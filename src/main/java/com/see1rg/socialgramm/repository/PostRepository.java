package com.see1rg.socialgramm.repository;

import com.see1rg.socialgramm.entity.Post;
import com.see1rg.socialgramm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUsersOrderByCreatedAtDesc(User user);
    List<Post> findAllByOrderByCreatedAtDesc();

    Optional<Post> findPostByIdAndUsers(Long id, User user);
}
