package dao;

import java.util.List;

import pojo.Lesson;

public interface LessonDAO {

    public void addLesson(List<Lesson> lessons);//���γ̱�
    public List<Lesson> queryLesson();//��ѯ�γ̱������������Lesson���͵�list
    public List<Lesson> queryBlurLesson(String name);//ģ����ѯ�γ̱���Ҫ����ĳһ���ؼ���
    public Lesson queryOneLesson(String name);//��ѯ�γ̱��е�ĳһ����Ϣ,����һ��LESSON����

    
}
