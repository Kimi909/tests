package com.kbp.security.browser.support;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/28.
 */
@Data
public class SimpleResponse {

    public Object content;

    public  SimpleResponse( Object content){
         this.content = content;
    }
}
