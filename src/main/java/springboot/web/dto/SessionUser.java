package springboot.web.dto;

import lombok.Getter;
import springboot.domain.user.User;

import java.io.Serializable;

// 세션에 사용자 정보를 저장하기 위한 클래스
// 인증된 사용자의 정보만 필요함
@Getter
public class SessionUser implements Serializable {

    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
