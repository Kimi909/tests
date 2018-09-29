package com.kbp.core.properties;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface SecurityConstants {

    /**
     * 默认的处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";

    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/auth/form";

    public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/auth/mobile" ;
}
