package com.project.springbootstudy.repository.user.Interface;

import com.project.springbootstudy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select * from tb_user where user_id = :userId and password = :password", nativeQuery = true)
    // 인터페이스 내 메서드는 자동으로 public이 붙는다
    // 아래의 경우에는 public User 메서드명(파라미터)와 같은 구조이다!
    User findByUserIdAndPassword(@Param(value = "userId") String userId, @Param(value="password") String password);
}
