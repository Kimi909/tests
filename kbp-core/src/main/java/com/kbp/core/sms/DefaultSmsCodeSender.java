package com.kbp.core.sms;

/**
 * Created by Administrator on 2018/9/29.
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号    " + mobile + "发送验证码：    " + code);
    }
}
