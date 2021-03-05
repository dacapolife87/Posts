package me.hjjang.posts.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hjjang.posts.api.dto.PostsSaveRequestDto;
import me.hjjang.posts.api.dto.PostsResponseDto;
import me.hjjang.posts.api.dto.PostsUpdateRequestDto;
import me.hjjang.posts.service.PostsService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        log.info(postsSaveRequestDto.toString());
        return postsService.save(postsSaveRequestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
