package com.ssq;

import java.util.Arrays;
import java.util.Random;


public class Ssq {
	
	public int countPossibleOutcomes(){
		int count = 0;
		count = (33*32*31*30*29*28)/(1*2*3*4*5*6)*16;
		return count;
	}
	
	public int[] possibleRedBallOutcomes(){
		int[] redBall = new int[6];
		Random random = new Random();
		for(int token=0; token<6; token++){
			int value = 1+random.nextInt(33);
			for(int temp=0; temp<token; temp++){
				if(value==redBall[temp]){
					--token;
				}
			}
			redBall[token]= value;
		}
		return redBall;
	}
	
	public int possibleBlueBallOutcomes(){
		Random random = new Random();
		int token = 1+random.nextInt(16);
		return token;
	}
	
	public static void main(String[] args) {
		Ssq ssq = new Ssq();
		int[] redBall = ssq.possibleRedBallOutcomes();
		Arrays.sort(redBall);
		for(int token: redBall){
			System.out.print(String.valueOf(token).concat(" "));
		}
		int blueBall = ssq.possibleBlueBallOutcomes();
		System.out.println(blueBall);
	}
	
	//У��,ͨ��Ա���ʷ���,��3�������Ϻ���Ľ��鲻Ҫ��;������������һ��,���������Լ������������ϵĽ��鲻Ҫ��
	public boolean validateSsq(){
		boolean isDuplicate = false;
		
		return isDuplicate;
	}

}
