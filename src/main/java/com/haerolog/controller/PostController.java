package com.haerolog.controller;

import com.haerolog.domain.Post;
import com.haerolog.request.PostCreate;
import com.haerolog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public void post(@RequestBody @Valid PostCreate request) {
        postService.write(request);
    }

    @GetMapping("/{postId}")
    public Post get(@PathVariable(name = "postId") Long id) {
        return postService.get(id);
    }

}
