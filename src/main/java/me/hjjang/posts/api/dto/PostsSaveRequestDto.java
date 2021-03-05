package me.hjjang.posts.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hjjang.posts.domain.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .build();
    }

    @Override
    public String toString() {
        return "PostSaveRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
