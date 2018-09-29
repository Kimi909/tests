package com.kbp.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2018/9/28.
 */
@ConfigurationProperties(prefix = "imooc.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private OAuth2Properties oauth2 = new OAuth2Properties();
}
