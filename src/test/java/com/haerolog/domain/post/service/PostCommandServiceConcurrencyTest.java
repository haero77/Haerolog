package com.haerolog.domain.post.service;

import com.haerolog.domain.post.model.Post;
import com.haerolog.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@SpringBootTest
public class PostCommandServiceConcurrencyTest {

    @Autowired
    private PostCommandService postCommandService;

    @SpyBean
    private PostRepository postRepository;

    @Test
    public void testConcurrentPostCreation() throws InterruptedException {
        final int numberOfThreads = 2;
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);

        final Long userId = 100L;
        final String title = "Test Title";
        final String content = "Test Content";

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                try {
                    latch.countDown();
                    latch.await(); // 모든 스레드가 준비될 때까지 대기
                    postCommandService.createPost(userId, title, content);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorService.shutdown();
        boolean finished = executorService.awaitTermination(100, TimeUnit.SECONDS);

        assertThat(finished).isTrue().withFailMessage("Execution timed out");

        // 실제로 저장된 포스트 수 확인
        final List<Post> all = postRepository.findAll();
        all.forEach(post -> System.out.println(post.toString()));

        assertThat(all).hasSize(1);

        verify(postRepository, times(numberOfThreads)).findByUserIdAndDeleted(userId, false);
    }
}