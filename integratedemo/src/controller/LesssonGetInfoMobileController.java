package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ClassInfo;
import service.ClassInfoManager;
import utils.SearchClassTable;

@ResponseBody
@Controller
public class LesssonGetInfoMobileController {

	
	@Autowired
	private ClassInfoManager classInfoManager;
	@RequestMapping(value="/get_ClassDate",method=RequestMethod.GET)
	public List<ClassInfo> getRealClassInfo(@RequestParam(value="lessonId", required = false)String lessonId) {
		//返回装有ClassInfo的List
		List<ClassInfo> list_classInfo = classInfoManager.queryClassInfo("20160", lessonId);
		
		return list_classInfo;
	}
}
