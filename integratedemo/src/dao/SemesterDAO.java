package dao;

import java.util.List;

import pojo.Semester;

public interface SemesterDAO {
	
    public void addSemester(List<Semester> semesters);//���ѧ�ڱ�
    public List<Semester> querySemester();//��ѯѧ�ڱ������������Semester���͵�list
    public Semester queryOneSemester(String value);//��ѯ�γ̱��е�ĳһ����Ϣ,����һ��Semester����


}
