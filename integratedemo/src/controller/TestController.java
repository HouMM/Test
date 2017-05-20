package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ClassInfoManager;
import service.LessonManager;
import service.SemesterManager;
import service.TeacherClassInfoManager;
import service.TeacherManager;
import pojo.*;

@ResponseBody
@Controller
public class TestController {
	@Autowired
	private LessonManager lessonManager;
	
	@Autowired
	private SemesterManager semesterMnager;
	
	@Autowired
	private TeacherManager teacherManger;
	
	@Autowired
	private ClassInfoManager classInfoManager;
	
	@Autowired
	private TeacherClassInfoManager teacherClassInfoManager;
	
	@RequestMapping(value="/testRequestParam",method = RequestMethod.POST)
	public String testRequestParam(@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age){
	    List<Lesson> lesson_list = new ArrayList<Lesson>();
	 /*   Lesson lesson1 = new Lesson("01", "lesson1");
	    Lesson lesson2 = new Lesson("02", "lesson2");
	    Lesson lesson3 = new Lesson("03", "lesson3");
	    lesson_list.add(lesson1);
	    lesson_list.add(lesson2);
	    lesson_list.add(lesson3);
	    lessonManager.addLesson(lesson_list);
	    
	    List<Semester> semester_list = new ArrayList<Semester>();
	    Semester semester1 = new Semester("01","semester1");
	    Semester semester2 = new Semester("02","semester2");
	    Semester semester3 = new Semester("03","semester3");
	    semester_list.add(semester1);
	    semester_list.add(semester2);
	    semester_list.add(semester3);
	    semesterMnager.addSemester(semester_list);
	    
	    List<Teacher> teacher_list = new ArrayList<Teacher>();
	    Teacher teacher1 = new Teacher("01", "teacher1");
	    Teacher teacher2 = new Teacher("02", "teacher2");
	    Teacher teacher3 = new Teacher("03", "teacher3");
	    teacher_list.add(teacher1);
	    teacher_list.add(teacher2);
	    teacher_list.add(teacher3);
	    teacherManger.addTeacher(teacher_list);
	    	    
	    
	    List<ClassInfo> classInfo_list = new ArrayList<ClassInfo>();
	    List<TeacherClassInfo> teacherClassInfo_list = new ArrayList<TeacherClassInfo>();
	    Semester se = semesterMnager.queryOneSemester("semester1");
	    Teacher te = teacherManger.queryOneTeacher("02");
	    Lesson le = lessonManager.queryOneLesson("lesson3");
	    
	    classInfo_list.add(new ClassInfo(se.getSe_key(), le.getLesson_id(), "title_info", "class_info"));
	    teacherClassInfo_list.add(new TeacherClassInfo(se.getSe_key(), te.getTeacher_id(), "title_info", "class_info"));
	    classInfoManager.addClassInfo(classInfo_list);
	    teacherClassInfoManager.addteacherClassInfo(teacherClassInfo_list);
	    
	    classInfo_list.clear();
	    teacherClassInfo_list.clear();
	    
	    classInfo_list = classInfoManager.queryClassInfo(se.getSe_key(), le.getLesson_id());
	    teacherClassInfo_list = teacherClassInfoManager.queryteacherClassInfo(se.getSe_key(), te.getTeacher_id());
	    
	    for(ClassInfo c : classInfo_list){
	    	System.out.println(c.getClass_info());
	    }
	    
	    for(TeacherClassInfo t: teacherClassInfo_list){
	    	System.out.println(t.getClass_info());
	    }*/
	    
	    return "success";
	}
	
	@RequestMapping(value="/testRequestParam",method = RequestMethod.GET)
	public String testRequestParam1(){
	    List<Lesson> lesson_list = lessonManager.queryLesson();
	    for(Lesson lesson : lesson_list){
	    	System.out.println(" lesson_id:" + lesson.getLesson_id() + " name:" + lesson.getName());
	    }
	    return "success";
	}

}
