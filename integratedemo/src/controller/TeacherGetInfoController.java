package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.TeacherClassInfo;
import service.TeacherClassInfoManager;
import utils.SearchTearchClassTable;

@ResponseBody
@Controller
public class TeacherGetInfoController {
	@Autowired
	private TeacherClassInfoManager teacherClassInfoManager;
	
	@RequestMapping(value="/get_teacherRealInfo",method=RequestMethod.GET)
	public List<TeacherClassInfo> getRealClassInfo(@RequestParam(value="teacherId", required = false)String teacherId, @RequestParam(value="identifycode", required=false) String identifyCode) {
		
		List<TeacherClassInfo> list_teacherclassInfo = teacherClassInfoManager.queryteacherClassInfo("20160", teacherId);
		if (list_teacherclassInfo.size() == 0) {
			list_teacherclassInfo = new ArrayList<>();
			List<List<String>> classDetail = SearchTearchClassTable.teacherGetRealClassesInfo(teacherId, identifyCode);
			if (classDetail != null) {
				List<String> list_title = classDetail.get(0);
				for (int i = 0; i < classDetail.get(1).size(); i++) {
					TeacherClassInfo t1 = new TeacherClassInfo("20160", teacherId, list_title.get(0), classDetail.get(1).get(i));
					list_teacherclassInfo.add(t1);
				}
				teacherClassInfoManager.addteacherClassInfo(list_teacherclassInfo);
			}
			
		}
		return list_teacherclassInfo;

	}
}
