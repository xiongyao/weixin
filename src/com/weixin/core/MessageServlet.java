package com.weixin.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MessageServlet extends HttpServlet {

	private static final long serialVersionUID = 7266463583343785339L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		 request.setCharacterEncoding("GBK");  
	     response.setCharacterEncoding("GBK");  
	     
	     PrintWriter out = response.getWriter();    //响应消息  
	     
	     List<HashMap<String,Object>>  messageList = queryMessage(request);
	     for(HashMap<String,Object> map:messageList){
	    	 out.println(map.get("my_title")+"  "+ map.get("my_message"));
	     }
	     out.flush();
	     out.close();
	}
	
	private static List<HashMap<String,Object>> queryMessage(HttpServletRequest request)throws ServletException, IOException{
		List<HashMap<String,Object>> messageList= new ArrayList<HashMap<String,Object>>();
		//获取数据库连接相关信息
		String url="jdbc:oracle:thin:@203.195.152.84:1521:orcl";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(url,"polly","xhytnetwork");
			String sql = "select my_title,my_message from message ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				HashMap<String,Object> messageMap =new HashMap<String,Object> ();
				messageMap.put("my_title", re.getString("my_title"));
				messageMap.put("my_message", re.getString("my_message"));
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
	
	 public void init() throws ServletException {
	    	
	  }
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	 
	 
}
