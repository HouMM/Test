package service;

import java.util.List;

import pojo.TeacherClassInfo;

public interface TeacherClassInfoManager {
	
	 public void addteacherClassInfo(List<TeacherClassInfo> teacherClassInfos);//添加到老师—课程信息表，抓取到信息时填入课程信息表，需要输入一个classInfo类型的list
	    public List<TeacherClassInfo> queryteacherClassInfo(String semester_key, String teacher_id);//根据老师ID和课程ID查询课程-老师信息表

}
