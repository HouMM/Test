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
import pojo.Lesson;
import service.ClassInfoManager;
import service.LessonManager;
import utils.LessonParser;
import utils.SearchClassTable;

@ResponseBody
@Controller
public class LessonGetClassInfoController {
	
	@Autowired
	private LessonManager lessonManager;
	
	@RequestMapping(value="/get_ClassInfo",method=RequestMethod.GET)
	public List<Lesson> getClassInfo() {
		//返回装有Lesson的List
		List<Lesson> list_classInfo = lessonManager.queryLesson();
		if (list_classInfo.size() == 0) {
			list_classInfo = new ArrayList<>();
			List<String> list_class = SearchClassTable.lessonGetLessonInfo();
			for (int i = 0; i < list_class.size(); i++) {
				list_classInfo.add(LessonParser.parseLesson(list_class.get(i)).get(0));
			}
			lessonManager.addLesson(list_classInfo);
		}
		return list_classInfo;
	}
}
