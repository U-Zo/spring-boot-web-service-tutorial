package springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스 명시, 언더스코어 네이밍으로 테이블 이름 매칭
public class Posts {

    @Id // 해당 테이블의 PK 필드
    // 복합키를 사용할 경우 유니크 키 따로 생성 권장
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    // GenerationType.IDENTITY: auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼 명시, 옵션이 필요한 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    // columnDefinition: 컬럼 타입 설정
    private String content;

    private String author;

    @Builder // 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
