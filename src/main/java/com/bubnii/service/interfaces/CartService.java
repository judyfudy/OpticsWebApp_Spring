package com.bubnii.service.interfaces;

import javax.servlet.http.HttpSession;

public interface CartService {
    void prepareOrderAndSendEmail(final HttpSession session, final String email);
}
