package service;

import java.util.List;

import pojo.TeacherClassInfo;

public interface TeacherClassInfoManager {
	
	 public void addteacherClassInfo(List<TeacherClassInfo> teacherClassInfos);//��ӵ���ʦ���γ���Ϣ��ץȡ����Ϣʱ����γ���Ϣ����Ҫ����һ��classInfo���͵�list
	    public List<TeacherClassInfo> queryteacherClassInfo(String semester_key, String teacher_id);//������ʦID�Ϳγ�ID��ѯ�γ�-��ʦ��Ϣ��

}
