package com.haerolog.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.domain.user.infrastructure.repository.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "api.haero77.com", uriPort = 443)
@AutoConfigureMockMvc
@ExtendWith(RestDocumentationExtension.class)
public class RestDocsSupport {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected PostRepository postRepository;

	@Autowired
	protected UserJpaRepository userJpaRepository;

	@BeforeEach
	void setUp() {
		userJpaRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();
	}

}
