package com.gduf.sbcms.Util;

import java.util.Date;

public class CalculationUtil {
	
	public static int calcula(Date startTime,Date endTime){
		Long time = endTime.getTime()-startTime.getTime();   
		int money = time.intValue()/1000/60/60*1;            //每小时1块钱		
		if(money==0||money<0)
			money=1;
		return money;
	}
}
