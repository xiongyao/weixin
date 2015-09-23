package com.weixin.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.service.CoreService;
import com.weixin.util.SignUtil;

public class CoreServlet extends HttpServlet {
private static final long serialVersionUID = 4440739483644821986L;  
	
    /**
     * 验证url和token
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String signature = request.getParameter("signature"); // 微信加密签名
        String timestamp = request.getParameter("timestamp");  // 时间戮
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");  // 随机字符串
        
        System.out.println("signature:"+signature+"            timestamp:"+timestamp+"            nonce:"+nonce+"               echostr:"+echostr);
        
        PrintWriter out = response.getWriter();
        // 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
       if(SignUtil.checkSignature(signature, timestamp, nonce)){
           out.print(echostr);
       }
 
       out.close();
       out = null; 
    }
 
    /**
     *用户向公众平台发信息并自动返回信息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        String respMessage = CoreService.processRequest(request);   //调用核心业务类接收消息、处理消息  
        PrintWriter out = response.getWriter();    //响应消息  
        out.print(respMessage);  
        out.close();  
         
    }
}
