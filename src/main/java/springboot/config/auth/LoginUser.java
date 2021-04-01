package springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target: 어노테이션 생성 위치 지정, PARAMETER로 했으니 파라미터로 선언된 객체에서 사용 가능
// @interface: 해당 클래스를 어노테이션 클래스로 지정
// @Retention: 해당 어노테이션이 유지되는 기간 지정
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
