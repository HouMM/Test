package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.TeacherDAO;
import pojo.Semester;
import pojo.Teacher;

@Repository
public class TeacherDAOimpl implements TeacherDAO{
	
	@PersistenceContext(name="mysql")
	private EntityManager manager;

	@Override
	public void addTeacher(List<Teacher> teachers) {
		// TODO Auto-generated method stub
		for(Teacher teacher : teachers){
			manager.persist(teacher);
		}
	}

	@Override
	public List<Teacher> queryTeacher() {
		// TODO Auto-generated method stub
		String jpql="from Teacher";
		List<Teacher> teachers=manager.createQuery(jpql).getResultList();
		return teachers;
	}

	@Override
	public List<Teacher> queryBlurTeacher(String name) {
		// TODO Auto-generated method stub
		String jpql="from Teacher t where t.name like :name";
		List<Teacher> teachers=manager.createQuery(jpql)
				.setParameter("name", "%"+name+"%")
				.getResultList();
		return teachers;
	}

	@Override
	public Teacher queryOneTeacher(String id) {
		// TODO Auto-generated method stub
		String jpql="from Teacher t where t.teacher_id =:teacher_id";
		List<Teacher> teachers=manager.createQuery(jpql)
				.setParameter("teacher_id", id)
				.getResultList();
		return teachers.get(0);
	}

}
