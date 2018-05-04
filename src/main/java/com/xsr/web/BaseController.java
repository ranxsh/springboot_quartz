package com.xsr.web;

import com.xsr.util.MyDateEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ranxsh on 2018/5/3.
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new MyDateEditor());
        binder.registerCustomEditor(Time.class, new CustomDateEditor(new SimpleDateFormat("HH:mm:ss"), true));
    }
}
