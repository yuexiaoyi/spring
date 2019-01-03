package com.lxy.frame;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(AuthorityCondition.class)
public class Authority {

    public void checkUserAuthority(){
        System.out.println("check user authority！");
    }

}
