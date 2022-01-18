package icu222.roomescape.domain.posts;

/* 현재 domain 패키지 내에 또 다른 패키지를 생성할 시
 * domain의 패키지 이름이 domain.이름으로 변하며 내부에 패키지 생성이 안 됨.
 * domain내부에 클래스를 만들고 패키지를 만들면 하위 패키지가 잘 만들어지는데,
 * 하위 패키지를 만든 뒤 domain 내부의 클래스를 삭제하면 다시 패키지 이름이 domain.이름 으로 변하며
 * 내부 패키지 또한 사라짐.
 */

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}

