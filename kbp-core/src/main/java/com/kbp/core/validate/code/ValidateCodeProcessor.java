package com.kbp.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    //创建验证码
    void create(ServletWebRequest request) throws  Exception;

    //校验验证码
    void  check(ServletWebRequest request) throws  Exception;

}
