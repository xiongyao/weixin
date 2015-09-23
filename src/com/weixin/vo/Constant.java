package com.weixin.vo;

/**   常量
 * @author fanhj
 */
public class Constant {
	
	//数据库连接信息
	public static final String DB_URL="jdbc:mysql://weixin.rdsm8aoesgdqiiz.rds.bj.baidubce.com/dtzq?useUnicode=true&characterEncoding=UTF8";
	public static final String DB_DRIVER="com.mysql.jdbc.Driver";
	public static final String DB_USER="szty";
	public static final String DB_PASSWORD="sztyadmin";

	//欢迎语
	public static final String WELCOME="卉都园艺是上海卉都园林绿化工程有限公司旗下品牌。上海卉都园林绿化工程有限公司是专业从事园林景观、绿化工程设计养护与施工、绿植花卉租赁与养护、会场布置、 鲜花、庆典礼仪、市政工程与养护、技术咨询于一体的综合性企业。公司另设有实体品牌“大自然花艺”门店。Tel：021-34010020 / 15000363661/微笑";

	//微信应用id
	public static final String AppID = "wxc5dc943c59637cf1";
	//微信应用秘钥
	public static final String AppSecret = "2c82dc1e33f5904603c725dcee1d53fd";
	
	// 微信的AccessToken请求URL地址
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+AppID+"&secret="+AppSecret;

}
