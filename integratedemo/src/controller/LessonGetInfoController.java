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
public class LessonGetInfoController {
	@Autowired
	private ClassInfoManager classInfoManager;
	
	@RequestMapping(value="/get_lessonRealInfo",method=RequestMethod.GET)
	public List<ClassInfo> getRealClassInfo(@RequestParam(value="lessonId", required = false)String lessonId, @RequestParam(value="identifycode", required=false) String identifyCode) {
		//返回装有ClassInfo的List
		List<ClassInfo> list_classInfo = classInfoManager.queryClassInfo("20160", lessonId);
		if (list_classInfo.size() == 0) {
			list_classInfo = new ArrayList<>();
			List<List<String>> classDetail = SearchClassTable.lessonGetRealClassesInfo(lessonId, identifyCode);
			System.out.println(classDetail.size());
			List<String> list_title = classDetail.get(0);
			for (int i = 0; i < classDetail.get(1).size(); i++) {
				ClassInfo cl = new ClassInfo("20160", lessonId, list_title.get(1), classDetail.get(1).get(i));
				list_classInfo.add(cl);
			}
			classInfoManager.addClassInfo(list_classInfo);
		}
		return list_classInfo;
	}
}
