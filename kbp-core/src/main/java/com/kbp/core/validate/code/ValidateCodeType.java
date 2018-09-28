package com.kbp.core.validate.code;

import com.kbp.core.properties.SecurityConstants;

/**
 * Created by Administrator on 2018/9/28.
 */
public enum ValidateCodeType {


    SMS {
        @Override
        public String getParaNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    IMAGE {
        @Override
        public String getParaNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    public abstract String getParaNameOnValidate();
}
