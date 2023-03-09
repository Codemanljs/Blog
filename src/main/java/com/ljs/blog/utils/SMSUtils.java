package com.ljs.blog.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 短信发送工具类
 */
public class SMSUtils {

   /**
    * 发送短信
    * @param signName 签名
    * @param templateCode 模板
    * @param phoneNumbers 手机号
    * @param param 验证码
    */
   public static void sendMessage(String signName, String templateCode,String phoneNumbers,String param){

      DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai","LTAI4FgBEaCz9Mu1hu2KpPhR", "yv5PA68Iy2ZtdchpeOVRmQweaOWkHp");
      /** use STS Token
       DefaultProfile profile = DefaultProfile.getProfile(
       "<your-region-id>",           // The region ID
       "<your-access-key-id>",       // The AccessKey ID of the RAM account
       "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
       "<your-sts-token>");          // STS Token
       **/

      IAcsClient client = new DefaultAcsClient(profile);

      SendSmsRequest request = new SendSmsRequest();
      request.setSignName("盘古广告");	//因为使用的是阿里云的短信测试，所以这两行不能更改
      request.setTemplateCode("SMS_204255313");
      request.setPhoneNumbers("15700235186");//这里传入的是你测试的手机号
      request.setTemplateParam("{\"code\":\""+param+"\"}");//这里传入的是短信验证码

      try {
         SendSmsResponse response = client.getAcsResponse(request);
         System.out.println("短信发送成功");
      } catch (ServerException e) {
         e.printStackTrace();
      } catch (ClientException e) {
         System.out.println("ErrCode:" + e.getErrCode());
         System.out.println("ErrMsg:" + e.getErrMsg());
         System.out.println("RequestId:" + e.getRequestId());
      }
   }

}
