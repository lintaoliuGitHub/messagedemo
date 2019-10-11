package com.beyondbit.ias.messagedemo.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;


/**
 * @author liulintao
 * @date 2019-09-19 14:36
 */
@Component
public class SendSms {

    public CommonResponse SendSms() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FqvLZD3H7GVoJiceGe7", "Oq6xisPJFth6Hwwjk6PWPVc7GPLRTB");
        IAcsClient client = new DefaultAcsClient(profile);

            CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "17621215666");
        request.putQueryParameter("SignName", "Mr.Liu");
        request.putQueryParameter("TemplateCode", "SMS_174272457");
        request.putQueryParameter("TemplateParam","{\"name\":\"用户\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
