package org.example.loginapp.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // 일반 회원가입
    @Transactional
    public void 회원가입(String username, String password, String email) {
        User user = new User().builder().
                username(username).
                password(password).
                email(email).
                build();

        userRepository.save(user);
    }

    public User 로그인(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("아이디가 없습니다.");
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new RuntimeException("비밀번호가 틀렸습니다.");
            }
        }
    }

    public User 카카오로그인(String code) {
        // 1. code로 카카오에서 토큰받기 (위임완료) = oauth2.0

        // 2. 토큰으로 사용자 정보 받기 (PK, Email)

        // 3. 해당정보로 db조회 (있을수도, 없을수도 있다)

        // 4. 있으면 - 조회된 유저정보 리턴

        // 5. 없으면 - 강제 회원가입
        // 유저네임 : (provider_pk)
        // 비밀번호 : UUID
        // 이메일 : 받은 Email 값
        // 프로바이더 : kakao


        return null;
    }
}
