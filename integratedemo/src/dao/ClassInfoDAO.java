package dao;

import java.util.List;

import pojo.ClassInfo;

public interface ClassInfoDAO {
	
    public void addClassInfo(List<ClassInfo> classInfos);//��ӵ��γ���-�γ���Ϣ��ץȡ����Ϣʱ����γ���Ϣ����Ҫ����һ��classInfo���͵�list
    public List<ClassInfo> queryClassInfo(String semester_key, String lesson_id);  //����ѧ�ںźͿγ̺Ų�ѯ�γ���Ϣ��
    

}
