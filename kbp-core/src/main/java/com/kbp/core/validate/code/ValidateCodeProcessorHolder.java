package com.kbp.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/28.
 */


@Component
public class ValidateCodeProcessorHolder {


    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(String type) throws ValidationException {

        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if(processor == null){
            throw  new ValidationException("验证码处理器" + name + "不存在");
        }
        return  processor;
    }

    /**
     * public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
     return findValidateCodeProcessor(type.toString().toLowerCase());
     }
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) throws ValidationException {
           return  findValidateCodeProcessor(type.toString().toLowerCase());
    }
}
