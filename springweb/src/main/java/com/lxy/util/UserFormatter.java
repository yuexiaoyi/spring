package com.lxy.util;

import com.lxy.vo.UserVO;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author lxy
 * @time 2019-01-04 23:28
 **/
public class UserFormatter implements Formatter<UserVO> {
    @Override
    public UserVO parse(String s, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(UserVO userVO, Locale locale) {
        return null;
    }
}
