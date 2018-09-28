package com.kbp.core.validate.code;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2018/9/28.
 */
@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code,int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode (String code,LocalDateTime expireTime){
        this.expireTime = expireTime;
        this.code = code;
    }

    public boolean isExpried(){
        return LocalDateTime.now().isAfter(expireTime);
    }

}
