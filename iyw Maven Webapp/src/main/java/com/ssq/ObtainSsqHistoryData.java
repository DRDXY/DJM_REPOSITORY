package com.ssq;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ObtainSsqHistoryData {
	
	public static void main(String[] args) {
		for(int token=2003; token<=2016; token++){
			String url = "http://www.3dcp.cn/zs/gonggao.php?type=ssq&year=";
			url = url.concat(String.valueOf(token));
			Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
				Elements elements = doc.select("span.end");
				for(Element element: elements){
					//期号
					String issue = element.html();
					System.out.println("期号"+issue);
					//开奖日期结点
					String secondNode = element.parent().nextElementSibling().html();
					System.out.println("开奖日期"+secondNode);
					
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
					System.out.println("红球"+red.substring(0, red.length()-1));
					System.out.println("篮球"+blueBallStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
