package com.project.springbootstudy.service.user;

import com.project.springbootstudy.domain.user.User;
import com.project.springbootstudy.repository.user.Interface.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void userJoin (User user) throws RuntimeException{

        /*
        1. 적합성 검사
        2. 제대로 되어 있으면 -> DB에 저장 (이거는 User 클래스에서 할 일!)
         */

        // 적합성 검사
        // 아이디 -> 중복 안됨!
        if(userRepository.findById(user.getUserId()).isPresent()) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }

        // 비밀번호 -> 영어, 숫자 혼용
        int upperEngCount = 0;
        int lowerEngCount = 0;
        int numCount = 0;

        for (int i=0; i<user.getPassword().length(); i++) {
            if (user.getPassword().charAt(i) >= 'a' && user.getPassword().charAt(i) <= 'z') lowerEngCount++;
            else if (user.getPassword().charAt(i) >= 'A' && user.getPassword().charAt(i) <= 'Z') upperEngCount++;
            else if (user.getPassword().charAt(i) >= '0' && user.getPassword().charAt(i) <= '9') numCount++;
        }

        if (lowerEngCount == 0 || upperEngCount == 0 || numCount == 0) {
            throw new RuntimeException("비밀번호에는 영소문자, 영대문자, 숫자가 모두 포함되어야 합니다");
        }

        // 비밀번호는 영어 소문자로 시작해야 한다!
        if (user.getPassword().charAt(0) < 'a' || user.getPassword().charAt(0) > 'z') {
            throw new RuntimeException("비밀번호는 영어 소문자로 시작해야 합니다!");
        }

        // 전화번호는 반드시 000 - 0000 - 0000의 형태여야 함!
        if (user.getPhone().charAt(3) != '-' || user.getPhone().charAt(8) != '-') {
            throw new RuntimeException("전화번호는 000-0000-0000 형태로 입력해주세요.");
        }

        // 전화번호는 무조건 14글자여야 함!
        if (user.getPhone().length() != 13) {
            throw new RuntimeException("전화번호는 000-0000-0000 형태로 입력해주세요.");
        }

        //System.out.println("여기 타나 ? ");
        userRepository.save(user);

    }

    public void userLogin (String userId, String password) throws RuntimeException {
        if (userRepository.findById(userId).isEmpty()) {
            throw new RuntimeException("존재하지 않는 회원입니다.");
        } else if(userRepository.findByUserIdAndPassword(userId, password) == null) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

}
