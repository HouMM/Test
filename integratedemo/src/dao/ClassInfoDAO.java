package dao;

import java.util.List;

import pojo.ClassInfo;

public interface ClassInfoDAO {
	
    public void addClassInfo(List<ClassInfo> classInfos);//添加到课程名-课程信息表，抓取到信息时填入课程信息表，需要输入一个classInfo类型的list
    public List<ClassInfo> queryClassInfo(String semester_key, String lesson_id);  //根据学期号和课程号查询课程信息表
    

}
