package com.kbp.core.properties;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/29.
 */

@Data
public class ValidateCodeProperties {

      private ImageCodeProperties image = new ImageCodeProperties();

      private SmsCodeProperties sms = new SmsCodeProperties();
}
