package com.xsr.util;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by ranxsh on 2018/5/3.
 */
public class MyDateEditor extends PropertiesEditor {

    @Override
    public void setAsText(String source) throws IllegalArgumentException {

        SimpleDateFormat sdf=getDate(source);
        //做一个操作
        try {
            setValue(sdf.parseObject(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private SimpleDateFormat getDate(String source) {
        SimpleDateFormat sdf=null;
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
            sdf=new SimpleDateFormat("yyyy-MM-dd");
        }else if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", source)) {
            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else{
            throw new TypeMismatchException("", Date.class);
        }
        return sdf;
    }
}
