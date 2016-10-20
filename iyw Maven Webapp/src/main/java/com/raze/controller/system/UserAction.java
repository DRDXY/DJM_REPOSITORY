package com.raze.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.raze.common.util.ParameterUtils;
import com.raze.service.IUserService;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: UserAction.java
 * @Description: 用户Action层
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
//@Controller("userAction")
public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 5275550289772164477L;
	
	@Autowired
	private IUserService userService;
	
	//获取所有用户信息
	public String execute() {
		Map<String, Object> requests = ActionContext.getContext().getParameters();
		Map<String, Object> conditions = ParameterUtils.getInstance().getParameter(requests);
		System.out.println(conditions);
		return "index";
	}
	
	//身份认证
	public String authentication() {
		/*Map<String, Object> requests = ActionContext.getContext().getParameters();
		Map<String, Object> conditions = ParameterUtils.getInstance().getParameter(requests);
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();  
		String userName = conditions.get("userName")==null? "": conditions.get("userName").toString();
		String password = conditions.get("password")==null? "": conditions.get("password").toString();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {  
	        subject.login(token); 
	    } catch (AuthenticationException e) {  
	    }  
		if(subject.isAuthenticated()){
			return "index";
		}else{
			return "login";
		}*/
		return "index";
	}
	
	public void inserSsq() {
		/*for(int token=2003; token<=2016; token++){
			SsqInfo ssq = new SsqInfo();
			String url = "http://www.3dcp.cn/zs/gonggao.php?type=ssq&year=";
			url = url.concat(String.valueOf(token));
			Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
				Elements elements = doc.select("span.end");
				for(Element element: elements){
					//期号
					String issue = element.html();
					ssq.setIssue(issue);
					//开奖日期结点
					String secondNode = element.parent().nextElementSibling().html();
					ssq.setOpend(secondNode);
					
					String redBallStr = "", blueBallStr="";
					Elements ballElements = element.parent().nextElementSibling().nextElementSibling().nextElementSibling().children();
					for (Element element2 : ballElements) {
						String tempBall = element2.html();
						if(redBallStr.isEmpty()){
							redBallStr = tempBall;
						}else{
							blueBallStr = tempBall;
						}
					}
					String red = redBallStr.replace("&nbsp;", ",");
					String realRed = red.substring(0, red.length()-1);
					ssq.setRed(realRed);
					ssq.setBlue(blueBallStr);
					
					//求和,平均值
					String[] redArray = realRed.split(",");
					Integer sum_only_red =0, sum_with_blue = 0;
					for (int i = 0; i < redArray.length; i++) {
						String string = redArray[i];
						sum_only_red+=Integer.valueOf(string);
					}
					ssq.setSum_only_red(sum_only_red);
					sum_with_blue = sum_only_red+Integer.valueOf(blueBallStr);
					ssq.setSum_with_blue(sum_with_blue);
					
					String average1 = CalculateUtil.quotient(sum_only_red, 6);
					String average2 = CalculateUtil.quotient(sum_with_blue, 7);
					ssq.setAverage_only_red(Float.valueOf(average1));
					ssq.setAverage_with_blue(Float.valueOf(average2));
					
					System.out.println("插入前"+ssq);
					userService.inserSsq(ssq);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	
	public void queryRedAndBlueDuplicate() {
		/*LIST<MAP<STRING, OBJECT>> SUMAMRYLIST = NEW ARRAYLIST<MAP<STRING, OBJECT>>();
		MAP<STRING, OBJECT> REQUESTS = ACTIONCONTEXT.GETCONTEXT().GETPARAMETERS();
		MAP<STRING, OBJECT> CONDITIONS = PARAMETERUTILS.GETINSTANCE().GETPARAMETER(REQUESTS);
		STRING SSQ = CONDITIONS.GET("SSQ")==NULL? "": CONDITIONS.GET("SSQ").TOSTRING();
		MAP<STRING, OBJECT> PARAMETERS = NEW HASHMAP<STRING, OBJECT>();
		LIST<SSQINFO> COMPREHENSIVELIST = USERSERVICE.OBTAINALLRECORD(PARAMETERS);
		IF(COMPREHENSIVELIST!=NULL&&COMPREHENSIVELIST.SIZE()>0){
			FOR (SSQINFO SSQINFO : COMPREHENSIVELIST) {
				SYSTEM.OUT.PRINTLN(SSQINFO);
				STRING RED = SSQINFO.GETRED();
				STRING BLUE = SSQINFO.GETBLUE();
				BOOLEAN FLAG = COMPAREARRAY(SSQ, RED, BLUE);
				IF(FLAG){
					MAP<STRING, OBJECT> TEMPMAP = NEW HASHMAP<STRING, OBJECT>();
					TEMPMAP.PUT("SSQHISTORYINFO", SSQINFO);
					SUMAMRYLIST.ADD(TEMPMAP);
				}
			}
		}
		MAP<STRING, OBJECT> RESULT = NEW HASHMAP<STRING, OBJECT>();
		RESULT.PUT("LIST", SUMAMRYLIST);
		SYSTEM.OUT.PRINTLN("不建议购买,与以下期号号码相似:"+RESULT);
		STRUTS2UTILS.RENDERJSON(RESULT);*/
	}
	
	
	public boolean compareArray(String selfBallNumber, String historyRed, String historyBlue){
		boolean isWorkable = false;
		if(selfBallNumber==null||selfBallNumber.isEmpty()||historyRed==null||historyRed.isEmpty()
				||historyBlue==null||historyBlue.isEmpty()){
			return isWorkable;
		}
		String[] selfArray = selfBallNumber.split("_");
		String[] histroyRedArray = historyRed.split(",");
		if(selfArray.length!=7||histroyRedArray.length!=6){
			return isWorkable; 
		}
		int redSame = 0, blueSame = 0;
		for(int token1=0; token1<selfArray.length-1; token1++){
			String selfSingleBall = selfArray[token1];
			for(int token2=0; token2<histroyRedArray.length; token2++){
				String historySingleBall = histroyRedArray[token2];
				if(selfSingleBall.equalsIgnoreCase(historySingleBall)){
					redSame++;
					break;
				}
			}
			if(selfArray[6].equalsIgnoreCase(historyBlue)){
				blueSame++;
			}
		}
		if(redSame>=3||(blueSame==1&&redSame>=2)){
			isWorkable = true;
		}
		return isWorkable;
	}
	
}
