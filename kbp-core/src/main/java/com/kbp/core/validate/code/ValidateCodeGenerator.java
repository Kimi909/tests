package com.kbp.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
