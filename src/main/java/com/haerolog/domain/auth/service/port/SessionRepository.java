package com.haerolog.domain.auth.service.port;

import com.haerolog.domain.auth.model.Session;

public interface SessionRepository {

    void save(Session session);

}
