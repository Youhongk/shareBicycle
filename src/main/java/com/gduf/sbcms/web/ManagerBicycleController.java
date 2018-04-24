package com.gduf.sbcms.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gduf.sbcms.entity.Bicycle;
import com.gduf.sbcms.entity.Feedback;
import com.gduf.sbcms.entity.Params;
import com.gduf.sbcms.entity.Riding;
import com.gduf.sbcms.service.BicycleService;
import com.gduf.sbcms.service.FeedbackService;
import com.gduf.sbcms.service.RidingService;

@RestController
@RequestMapping("/manager/bicycle")
public class ManagerBicycleController {

	@Autowired
	BicycleService bicycleService;
	@Autowired
	RidingService ridingService;
	@Autowired
	FeedbackService feedbackService;
	
	Bicycle bicycle;
	
	@RequestMapping("/getParamInit")
	public List<Params> getParamInit(@RequestBody Map map) throws Exception{		
		List<Params> list = bicycleService.getParamData(map.get("paramName").toString());
		return list;
	}
	
	@RequestMapping("/getAllBicycleData")
	public List<Bicycle> getAllBicycleData() throws Exception{
		Bicycle bicycle = new Bicycle();
		List<Bicycle> list = bicycleService.getBicycleData(bicycle);
		return list;
	}
	
	@RequestMapping("/getBicycleData")
	public List<Bicycle> getBicycleData(@RequestBody Bicycle bicycle) throws Exception{
		
		List<Bicycle> list = bicycleService.getBicycleData(bicycle);
		return list;
	}
	
	@RequestMapping("/getRidingData")
	public List<Riding> getRidingData(@RequestBody Riding riding) throws Exception{
		//这里还可以按条件改变需要查询的参数值		
		return ridingService.getBicycleData(riding);
	}
		
	@RequestMapping("/getFeedbackData")
	public List<Feedback> getFeedbackData(@RequestBody Feedback feedback) throws Exception{				
		return feedbackService.getFeedbackData(feedback);
	}

	@RequestMapping("/updateBicycle")
	public String updateBicycle(@RequestBody Bicycle bicycle) throws Exception{				
		 bicycleService.updateByPrimaryKeySelective(bicycle);
		 return "1";
	}
	
	@RequestMapping("/doBatchOpera")
	public String doBatchOpera(@RequestBody List<String> list,HttpServletRequest req) throws Exception{				
		 
		 String type = req.getParameter("type");
		 String regional = req.getParameter("regional");		
		 String fixType = req.getParameter("fixType");
		 String cd = req.getParameter("cd");
		 String idsList = list.toString();
		 String ids=idsList.substring(1, idsList.length()-1);
		   
		 if(type!=null){
			 bicycle = new Bicycle();
			 if(type.equals("stroage") || 
					 type.equals("fix")&&fixType.equals("3")){     //入库
				bicycle.setBicycleStatus(3);				
			 }else if(type.equals("ouput")){                       //投放
				 bicycle.setBicycleStatus(4);
				 bicycle.setRegional(regional);
				 bicycle.setCoordinates(cd);
			 }else if(type.equals("recycle")){                     //回收
				 bicycle.setBicycleStatus(7);				 
			 }else if(type.equals("fix")&&fixType.equals("8")){	   //报废		 
				 bicycle.setBicycleStatus(8);				 
			 }
			 bicycleService.updateBatch(ids, bicycle);
		 }
		 return "1";
	}
	
	@RequestMapping("/bicycleInit")
	public List<Bicycle> bicycleInit() throws Exception{	
		return bicycleService.regionalInit();
	}
}
