package com.capstone3.GroupAppoint.kakao.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone3.GroupAppoint.kakao.auth.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}