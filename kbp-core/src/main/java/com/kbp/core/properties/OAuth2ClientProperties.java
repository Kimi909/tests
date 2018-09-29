package com.kbp.core.properties;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/29.
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private int accessTokenValidateSeconds = 7200;
}
