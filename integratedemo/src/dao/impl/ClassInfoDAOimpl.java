package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.ClassInfoDAO;
import pojo.ClassInfo;


@Repository
public class ClassInfoDAOimpl implements ClassInfoDAO{
	
	@PersistenceContext(name="mysql")
	private EntityManager manager;

	@Override
	public void addClassInfo(List<ClassInfo> classInfos) {
		for(ClassInfo classinfo : classInfos){
			manager.persist(classinfo);
		}
	}

	@Override
	public List<ClassInfo> queryClassInfo(String semester_key, String lesson_id) {
		// TODO Auto-generated method stub
		String jpql="from ClassInfo c where c.semester_key=:semester_key and c.lesson_id=:lesson_id";
		List<ClassInfo> ClassInfos=manager.createQuery(jpql)
				.setParameter("semester_key", semester_key)
				.setParameter("lesson_id", lesson_id)
				.getResultList();
		return ClassInfos;
	}

}
