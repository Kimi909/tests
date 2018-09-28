package com.kbp.core.properties;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/28.
 */
@Data
public class BrowserProperties {

    //默认登录页
    private String loginPage = "/imooc-signIn.html";

    //默认返回值类型
    private LoginType loginType = LoginType.JSON;


}
