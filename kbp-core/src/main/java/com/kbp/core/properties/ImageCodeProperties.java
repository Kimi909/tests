package com.kbp.core.properties;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/29.
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 67;
    private int height = 23;
}
