package com.capstone3.GroupAppoint.kakao.auth.controller;

import com.capstone3.GroupAppoint.kakao.auth.dto.UserInfoResponseDto;
import com.capstone3.GroupAppoint.kakao.auth.entity.User;
import com.capstone3.GroupAppoint.kakao.auth.repository.UserRepository;
import com.capstone3.GroupAppoint.kakao.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/id")
    public ResponseEntity<UserInfoResponseDto>  getAccountId(HttpServletRequest request) {
        String email = request.getRemoteUser();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            log.info("account.get().getAccountId(): " + user.get().getUserId());
            log.info("account.get().getName(): " + user.get().getName());
            log.info("account.get().getProfile(): " + user.get().getProfile());

            UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto(user.get().getUserId(), user.get().getName(), user.get().getProfile());
            return ResponseEntity.ok(userInfoResponseDto);
        }

    }
}
