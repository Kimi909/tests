package com.kbp.core.validate.code.impl;

import com.kbp.core.validate.code.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Created by Administrator on 2018/9/28.
 */
public abstract  class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
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


    /**
     * 保存校验码
     */
    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request,getSessionKey(request),validateCode);
    }

    private String getSessionKey(ServletWebRequest request) {
        return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

    /**
     * 发送校验码，子类实现
     * @param request
     * @param validateCode
     */
    protected abstract void send(ServletWebRequest request, C validateCode);


    public  void validate(ServletWebRequest request){

        ValidateCodeType processorType = getValidateCodeType(request);
        String sessionKey = getSessionKey(request);

        C codeInSession = (C)sessionStrategy.getAttribute(request, sessionKey);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),processorType.getParaNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidationException("获取验证码的值失败");
        }

        if(StringUtils.isEmpty(codeInRequest)){
            throw new ValidationException(processorType + "验证码不能为空");
        }
        if (codeInSession == null){
            throw new ValidationException(processorType + "验证码不存在");
        }
        if(codeInSession.isExpried()){
            throw new ValidationException(processorType + "验证码过期");
        }
        if(!StringUtils.equals(codeInSession.getCode(),codeInRequest)){
            throw new ValidationException(processorType + "验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, sessionKey);
    }

}
