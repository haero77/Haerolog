package com.haerolog.domain.auth.infrastructure.persistence;

import com.haerolog.domain.auth.model.Session;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "session")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String accessToken;

    private Long userId;

    @Builder
    private SessionEntity(String accessToken, Long userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public static SessionEntity fromModel(Session session) {
        return SessionEntity.builder()
                .accessToken(session.getAccessToken())
                .userId(session.getUserId())
                .build();
    }

    public Session toModel() {
        return Session.builder()
                .id(this.id)
                .accessToken(this.accessToken)
                .userId(this.userId)
                .build();
    }

}
