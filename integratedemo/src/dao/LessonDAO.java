package dao;

import java.util.List;

import pojo.Lesson;

public interface LessonDAO {

    public void addLesson(List<Lesson> lessons);//填充课程表
    public List<Lesson> queryLesson();//查询课程表，返回整个表的Lesson类型的list
    public List<Lesson> queryBlurLesson(String name);//模糊查询课程表，需要输入某一个关键字
    public Lesson queryOneLesson(String name);//查询课程表中的某一条信息,返回一个LESSON对象

    
}
