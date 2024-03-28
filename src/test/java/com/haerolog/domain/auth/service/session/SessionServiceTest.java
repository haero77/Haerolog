package com.haerolog.domain.auth.service.session;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.user.model.User;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.Test;

class SessionServiceTest extends IntegrationTestSupport {

    @Test
    void name() {
        // given
        Session session = Session.builder()
                .accessToken("aaa-aaa-aaa-aaa")
                .user(User.builder()
                        .userId(10L)
                        .build())
                .build();

        super.sessionRepository.save(session);

        // when

        // then
    }

}