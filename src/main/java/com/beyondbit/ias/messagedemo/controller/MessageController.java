package com.beyondbit.ias.messagedemo.controller;

import com.aliyuncs.CommonResponse;
import com.beyondbit.ias.messagedemo.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liulintao
 * @date 2019-09-19 14:51
 */
@Controller
public class MessageController {

    @Autowired
    SendSms sendSms;
    @Value("${alibaba.message.TestValue}")
    String testvalue;
    @RequestMapping("/")
    public String messageView(Model model) {

        model.addAttribute("value",testvalue);
        System.out.println(testvalue);
        return "/index.html";
    }

    @RequestMapping("/message")
    @ResponseBody
    public CommonResponse sendSms() {
        CommonResponse commonRequest = sendSms.SendSms();
        return commonRequest;
    }
}

