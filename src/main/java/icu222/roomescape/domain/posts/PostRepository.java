package icu222.roomescape.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


// CRUD method 자동 생성
public interface PostRepository extends JpaRepository<Posts, Long> {

}
