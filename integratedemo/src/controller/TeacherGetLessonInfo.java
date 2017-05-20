package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Teacher;
import service.TeacherManager;
import utils.SearchTearchClassTable;
import utils.TeacherParser;

@ResponseBody
@Controller
public class TeacherGetLessonInfo {
	
	@Autowired
	private TeacherManager teacherManager;
	
	@RequestMapping(value="/get_TeacherInfo",method=RequestMethod.GET)
	public List<Teacher> getTeacherInfo() {
		//返回装有Teacher的list
		List<Teacher> list_teacherInfo = teacherManager.queryTeacher();
		if (list_teacherInfo.size() == 0) {
			list_teacherInfo = new ArrayList<>();
			List<String> list_teacher = SearchTearchClassTable.teacherGetLessonInfo();
			for (int i = 0; i < list_teacher.size(); i++) {
				list_teacherInfo.add(TeacherParser.parseTeacher(list_teacher.get(i)).get(0));
			}
			teacherManager.addTeacher(list_teacherInfo);
		}
		return list_teacherInfo;
	}
}