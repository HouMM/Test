package dao;

import java.util.List;

import pojo.Teacher;

public interface TeacherDAO {

    public void addTeacher(List<Teacher> teachers);//填充老师表
    public List<Teacher> queryTeacher();//查询老师表，返回整个表的Teacher类型的list
    public List<Teacher> queryBlurTeacher(String name);//模糊查询老师表，需要输入某一个关键字
    public Teacher queryOneTeacher(String id);//查询老师表中的某一条信息,返回一个TEACHER对象,由于姓名有重复，必须使用ID查询



}
