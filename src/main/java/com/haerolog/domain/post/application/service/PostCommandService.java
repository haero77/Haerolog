package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommandService {

	private final PostReader postReader;
	private final PostRepository repository;

}
