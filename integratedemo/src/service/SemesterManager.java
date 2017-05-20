package service;

import java.util.List;

import pojo.Semester;

public interface SemesterManager {

	public void addSemester(List<Semester> semesters);//填充学期表
    public List<Semester> querySemester();//查询学期表，返回整个表的Semester类型的list
    public Semester queryOneSemester(String value);//查询课程表中的某一条信息,返回一个Semester对象

}
