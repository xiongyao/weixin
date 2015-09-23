package com.weixin.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.weixin.util.MessageUtil;
import com.weixin.vo.Constant;
import com.weixin.vo.resq.Article;
import com.weixin.vo.resq.NewsMessage;
import com.weixin.vo.resq.TextMessage;

public class CoreService {
	
	/**
	 * @return 数据库连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url= Constant.DB_URL;
		Class.forName(Constant.DB_DRIVER);
		Connection conn = DriverManager.getConnection(url, Constant.DB_USER, Constant.DB_PASSWORD);
		return conn;
	}
	
	 /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 默认回复此文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            // 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义  
            textMessage.setContent(Constant.WELCOME);  
            // 将文本消息对象转换成xml字符串  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                // 接收用户发送的文本消息内容  
                String content = requestMap.get("Content");  
  
                // 创建图文消息  
                NewsMessage newsMessage = new NewsMessage();  
                newsMessage.setToUserName(fromUserName);  
                newsMessage.setFromUserName(toUserName);  
                newsMessage.setCreateTime(new Date().getTime());  
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                newsMessage.setFuncFlag(0);  
  
                List<Article> articleList = new ArrayList<Article>();  
                // 单图文消息  
                if ("1".equals(content) || "2".equals(content)) {  
                    List<HashMap<String,Object>>  messageList =queryMessage(content);
                    for(HashMap<String,Object> map:messageList){
                    	 Article article = new Article();  
                         article.setTitle(String.valueOf(map.get("my_title"))); 
                         article.setDescription(String.valueOf(map.get("my_message")));
                         article.setPicUrl(String.valueOf(map.get("picUrl")));
                         article.setUrl(String.valueOf(map.get("messageUrl")));  
                         articleList.add(article);  
           	     	}
                  
                    newsMessage.setArticleCount(articleList.size());   //设置图文消息个数  
                    newsMessage.setArticles(articleList); //设置图文消息包含的图文集合    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage); //将图文消息对象转换成xml字符串  
                }  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return respMessage;  
    }  
    
	private static List<HashMap<String,Object>> queryMessage(String content)throws ServletException, IOException{
		List<HashMap<String,Object>> messageList= new ArrayList<HashMap<String,Object>>();
		//获取数据库连接相关信息
//		String url="jdbc:oracle:thin:@203.195.152.84:1521:orcl";
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = getConnection();
			String sql = "select my_title,my_message,picUrl,messageUrl,MY_TIME from message where type = '"+content+"' order by MY_TIME ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				HashMap<String,Object> messageMap =new HashMap<String,Object> ();
				messageMap.put("my_title", re.getString("my_title"));
				messageMap.put("my_message", re.getString("my_message"));
				messageMap.put("picUrl", re.getString("picUrl"));
				messageMap.put("messageUrl", re.getString("messageUrl"));
				messageList.add(messageMap);
			}
			re.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList;
	}
	
  
    /** 
     * emoji表情转换(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
    }  
}


