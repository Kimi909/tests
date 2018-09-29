package com.kbp.core.properties;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/29.
 */
@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;
}
