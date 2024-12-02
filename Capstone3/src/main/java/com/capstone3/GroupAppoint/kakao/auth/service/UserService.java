package com.capstone3.GroupAppoint.kakao.auth.service;

import com.capstone3.GroupAppoint.kakao.auth.entity.User;
import com.capstone3.GroupAppoint.kakao.auth.entity.Friend;
import com.capstone3.GroupAppoint.kakao.auth.repository.UserRepository;
import com.capstone3.GroupAppoint.kakao.auth.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    // User 조회
    public User findByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("존재하지 않는 회원");
        }
    }

    // User 생성
    public User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    // Friend 추가
    public Friend addFriend(Long userId, String friendName) {
        // 사용자 조회
        User user = findByUserId(userId);

        // Friend 객체 생성
        Friend friend = new Friend(user, friendName);

        // Friend 저장
        return friendRepository.save(friend);
    }

    // User의 모든 Friend 조회
    public List<Friend> findAllFriends(Long userId) {
        // 사용자 조회
        User user = findByUserId(userId);

        // User와 연결된 모든 Friend 반환
        return user.getFriends();
    }
}

