package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.TeacherClassInfoDAO;
import pojo.TeacherClassInfo;

@Repository
public class TeacherClassInfoDAOimpl implements TeacherClassInfoDAO{
	@PersistenceContext(name="mysql")
	private EntityManager manager;

	@Override
	public void addteacherClassInfo(List<TeacherClassInfo> teacherClassInfos) {
		// TODO Auto-generated method stub
		for(TeacherClassInfo teacherclassinfo : teacherClassInfos){
			manager.persist(teacherclassinfo);
		}
	}

	@Override
	public List<TeacherClassInfo> queryteacherClassInfo(String semester_key,
			String teacher_id) {
		// TODO Auto-generated method stub
		String jpql="from TeacherClassInfo t where t.semester_key=:semester_key and t.teacher_id=:teacher_id";
		List<TeacherClassInfo> teacherClassInfos=manager.createQuery(jpql)
				.setParameter("semester_key", semester_key)
				.setParameter("teacher_id", teacher_id)
				.getResultList();
		return teacherClassInfos;
	}

}
