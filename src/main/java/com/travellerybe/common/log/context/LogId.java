package com.travellerybe.common.log.context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.travellerybe.common.auth.AuthConstant.JSESSION_ID;

public interface LogId {

    static LogId fromRequest(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return AnonymousLogId.randomId();
        }
        return new AuthenticatedLogId(session.getAttribute(JSESSION_ID));
    }

    String logId();
}
