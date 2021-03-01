package springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
// Dto 클래스는 Entity 클래스와 유사함에도 Request/Response 클래스로 사용해서는 안 된다.
// 데이터베이스와 맞닿은 핵심 클래스이기 때문에.
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
