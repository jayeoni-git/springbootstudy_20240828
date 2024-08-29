package com.project.springbootstudy;

import com.project.springbootstudy.domain.user.User;
import com.project.springbootstudy.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void 비밀번호테스트_소문자만있음() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("wkdus");

        userService.userJoin(user);
    }

    @Test
    public void 비밀번호테스트_대문자만있음() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("WKDUS");

        userService.userJoin(user);
    }

    @Test
    public void 비밀번호테스트_숫자만있음() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("11111");

        userService.userJoin(user);
    }

    @Test
    public void 비밀번호테스트_숫자빠짐() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("wkdusWKDUS");

        userService.userJoin(user);

    }

    @Test
    public void 비밀번호테스트_대문자빠짐() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("wkdus1111");

        userService.userJoin(user);

    }

    @Test
    public void 비밀번호테스트_소문자빠짐() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("WKDUS1111");

        userService.userJoin(user);

    }

    @Test
    public void 비밀번호테스트_소문자로시작안함() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setPhone("010-6626-3959");
        user.setHomeAddr("경기 안산");

        // 테스트용 비번
        user.setPassword("Wwkdus1111");

        userService.userJoin(user);

    }

    @Test
    public void 전화번호테스트_빼기미포함() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setPassword("wkdus1111A");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setHomeAddr("경기 안산");

        // 테스트용 전화번호
        user.setPhone("010-66263959");

        userService.userJoin(user);

    }

    @Test
    public void 전화번호테스트_길이불일치() {
        // 테스트용 user 클래스 만들기
        User user = new User();

        user.setUserId("wkdus");
        user.setPassword("wkdus1111A");
        user.setName("엄자연");
        user.setGender('F');
        user.setAge(26);
        user.setHomeAddr("경기 안산");

        // 테스트용 전화번호
        user.setPhone("010-6626-399");

        userService.userJoin(user);

    }

    @Test
    public void 없는회원일경우_테스트() {
        String userId = "jayen";
        String password = "abcd1234A";

        userService.userLogin(userId, password);
    }

    @Test
    public void 비밀번호가틀렸을경우_테스트() {
        String userId = "jayeon";
        String password = "abcd1234";

        userService.userLogin(userId, password);
    }

    @Test
    public void 로그인_성공_테스트() {
        String userId = "jayeon";
        String password = "abcd1234A";

        userService.userLogin(userId, password);
    }

}
