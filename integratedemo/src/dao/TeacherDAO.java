package dao;

import java.util.List;

import pojo.Teacher;

public interface TeacherDAO {

    public void addTeacher(List<Teacher> teachers);//�����ʦ��
    public List<Teacher> queryTeacher();//��ѯ��ʦ�������������Teacher���͵�list
    public List<Teacher> queryBlurTeacher(String name);//ģ����ѯ��ʦ����Ҫ����ĳһ���ؼ���
    public Teacher queryOneTeacher(String id);//��ѯ��ʦ���е�ĳһ����Ϣ,����һ��TEACHER����,�����������ظ�������ʹ��ID��ѯ



}
