package com.kbp.core.sms;

/**
 * Created by Administrator on 2018/9/29.
 */
public interface SmsCodeSender {

    void send(String mobile,String code );
}
