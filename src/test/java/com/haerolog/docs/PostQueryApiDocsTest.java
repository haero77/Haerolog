package com.haerolog.docs;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(RestDocumentationExtension.class)
class PostQueryApiDocsTest extends IntegrationTestSupport {

	private MockMvc mockMvc;

	@AfterEach
	void afterEach() {
		super.postRepository.deleteAllInBatch();
	}

	@BeforeEach
	void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation))
				.build();
	}

	@DisplayName("docs test")
	@Test
	void test1() throws Exception {
		Post post = Post.builder()
				.title("123456789012345")
				.content("content")
				.build();
		postRepository.save(post);

		// expected
		mockMvc.perform(get("/posts/{postId}", post.getId()).accept(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("index"));
	}

}
