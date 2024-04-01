package com.haerolog.domain.auth.service.session;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.user.model.User;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SessionServiceTest extends IntegrationTestSupport {

    @Autowired
    SessionRepository sessionRepository;

    @AfterEach
    void afterEach() {
        sessionRepository.deleteAllInBatch();
    }

    @Test
    void name() {
        // given
        Session session = Session.builder()
                .accessToken("aaa-aaa-aaa-aaa")
                .user(User.builder()
                        .userId(10L)
                        .build())
                .build();

        sessionRepository.save(session);

        // when

        // then
    }

}