package com.example.designpatterns.patterns.state.utils;


import com.example.designpatterns.patterns.state.enums.CommonEnum;

/**
 * className EnumUtil
 * date 2021/1/15
 *
 * @author JC
 */
public class EnumUtil {

    public static <T extends CommonEnum> T getEnumByCode(Class<T> enumClass, int code){
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (code == enumConstant.getCode()) {
                return enumConstant;
            }
        }
        return null;
    }

    public static <T extends CommonEnum> T getEnumByName(Class<T> enumClass,String name){
        if (name==null) {
            return null;
        }
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (name.equals(enumConstant.getShowName())) {
                return enumConstant;
            }
        }
        return null;
    }
}
