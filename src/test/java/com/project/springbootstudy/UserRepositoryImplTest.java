package com.project.springbootstudy;

import com.project.springbootstudy.domain.user.User;
//import com.project.springbootstudy.repository.user.Implement.UserRepositoryImpl;
import com.project.springbootstudy.repository.user.Interface.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입_테스트() {
        User user = new User();
        user.setUserId("wkdus111");
        user.setPassword("wkdus1111W");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        userRepository.save(user);
    }

    @Test
    public void 로그인_테스트() {
        User result = userRepository.findByUserIdAndPassword("jayeon", "abcd1234A");
        System.out.println(result);
    }
}
