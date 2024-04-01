package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.auth.service.session.SessionAppend;
import com.haerolog.domain.auth.service.session.SessionAppender;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import com.haerolog.domain.user.service.UserReader;
import com.haerolog.global.service.UuidHolder;
import com.haerolog.mock.FakeUuidHolder;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SessionAppenderTest extends IntegrationTestSupport {

    @Autowired
    UserReader userReader;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @AfterEach
    void afterEach() {
        userRepository.deleteAllInBatch();
        sessionRepository.deleteAllInBatch();
    }

    @DisplayName("세션을 추가한다.")
    @Test
    void append() {
        User user = User.builder()
                .build();
        userRepository.save(user);

        UuidHolder uuidHolder = new FakeUuidHolder("aaa-aaa-aaa-aaa");
        SessionAppender sut = new SessionAppender(sessionRepository, uuidHolder, userReader);

        SessionAppend sessionAppend = SessionAppend.builder()
                .userId(user.getUserId())
                .build();

        sut.append(sessionAppend);

        Session session = sessionRepository.findAll().get(0);
        assertAll(
                () -> assertThat(session.getUser().getUserId()).isEqualTo(user.getUserId()),
                () -> assertThat(session.getAccessToken()).isEqualTo("aaa-aaa-aaa-aaa")
        );
    }

}