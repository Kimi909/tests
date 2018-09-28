package com.kbp.core.validate.code.impl;

import com.kbp.core.validate.code.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Created by Administrator on 2018/9/28.
 */
public abstract  class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {

        C  validateCode = generate(request);
        save(request,validateCode);
        send(request,validateCode);

    }

    /**
     * 生成校验码
     */
    protected  C generate(ServletWebRequest request){

        //IMAGE、SMS --->iamge、sms
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if(validateCodeGenerator == null){
            throw new ValidationException("验证码生成器" + generatorName + "不存在");
        }
        return  (C) validateCodeGenerator.generate(request);
    }

    private ValidateCodeType getValidateCodeType(ServletWebRequest request) {

        String type = StringUtils.substringBefore(getClass().getSimpleName(),"CodeProcessor");
        return  ValidateCodeType.valueOf(type.toUpperCase());

    }

    ;
}
