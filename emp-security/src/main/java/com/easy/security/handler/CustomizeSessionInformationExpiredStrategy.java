package com.easy.security.handler;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @Packge com.easy.security.handler
 * @Autor linNaibin
 * @Description 会话信息过期策略
 * and().sessionManagement().
 * maximumSessions(1)
 * @Version 1.0
 * @Date 2021/2/7 16:57
 */
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        System.out.println(" session 过期. ");
    }
}
