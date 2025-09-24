package com.example.milo.services;

import com.example.milo.dto.UserDto;
import com.example.milo.dto.UserSignupDto;
import com.example.milo.models.User;
import com.example.milo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        return new UserDto(user.getUser_name(),
                user.getEmail());
    }

    public UserDto signupUser(UserSignupDto userSignupDto) {
        // 이메일 중복 확인
        if (userRepository.findByEmail(userSignupDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User user = new User();
        user.setUser_name(userSignupDto.getUser_name());
        user.setEmail(userSignupDto.getEmail());
        user.setCreated_at(LocalDateTime.now());
        user.setDeleted_at(null); //회원가입 시점에는 null로 설정

        // 비밀번호 암호화 저장
        String encodedPassword = passwordEncoder.encode(userSignupDto.getPassword());
        user.setPassword(encodedPassword);

        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getUser_name(), savedUser.getEmail());
    }
}