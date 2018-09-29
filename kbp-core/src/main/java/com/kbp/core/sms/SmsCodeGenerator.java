package com.kbp.core.sms;

import com.kbp.core.properties.SecurityProperties;
import com.kbp.core.validate.code.ValidateCode;
import com.kbp.core.validate.code.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Administrator on 2018/9/29.
 */
@Component("smsValidateCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {

        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }
}
