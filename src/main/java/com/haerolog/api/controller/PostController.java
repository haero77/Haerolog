package com.haerolog.api.controller;

import com.haerolog.api.domain.Post;
import com.haerolog.api.request.PostCreate;
import com.haerolog.api.service.PostService;
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
