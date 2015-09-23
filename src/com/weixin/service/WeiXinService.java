package com.weixin.service;

import com.weixin.vo.Constant;

public class WeiXinService {

	public static String getAccessToken() {  
        String returnString="";
        String requestUrl = Constant.ACCESS_TOKEN_URL;  
//        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  //Http GET请求
//        // 如果请求成功   
//        if (null != jsonObject) {  
//            try {  
//                returnString=jsonObject.getString("access_token");  
//            } catch (JSONException e) {  
//                returnString = null;  
//            }  
//        }  
        return returnString;  
    } 
	
}
