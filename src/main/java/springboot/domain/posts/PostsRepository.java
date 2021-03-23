package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository<Entity 클래스, PK 타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // @Query: JPA에서 제공하지 않는 쿼리를 직접 작성할 수 있음
    // querydsl 추후 모듈 참고
    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
