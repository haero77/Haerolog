package com.haerolog.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haerolog.domain.auth.infrastructure.persistence.SessionJpaRepository;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.domain.user.infrastructure.persistence.UserJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public abstract class IntegrationTestSupport {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected PostRepository postRepository;

    @Autowired
    protected UserJpaRepository userJpaRepository;

    @Autowired
    protected SessionJpaRepository sessionJpaRepository;

    @AfterEach
    void afterEach() {
        postRepository.deleteAllInBatch();
        userJpaRepository.deleteAllInBatch();
        sessionJpaRepository.deleteAllInBatch();
    }

}
