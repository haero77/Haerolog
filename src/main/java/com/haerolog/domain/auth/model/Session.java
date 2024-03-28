package com.haerolog.domain.auth.model;

import com.haerolog.domain.user.model.User;
import com.haerolog.global.model.BaseTimeEntity;
import com.haerolog.global.service.UuidHolder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Session extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long sessionId;

    @Column(nullable = false)
    private String accessToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private User user;

    @Builder
    private Session(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public static Session of(UuidHolder uuidHolder, User user) {
        return Session.builder()
                .accessToken(uuidHolder.random())
                .user(user)
                .build();
    }

    public Long fetchUserId() {
        return this.user.getUserId();
    }

}
