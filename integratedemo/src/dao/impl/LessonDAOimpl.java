package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.LessonDAO;
import pojo.Lesson;

@Repository
public class LessonDAOimpl implements LessonDAO{
	
	
	@PersistenceContext(name="mysql")
	private EntityManager manager;

	@Override
	public void addLesson(List<Lesson> lessons) {
		// TODO Auto-generated method stub
		for(Lesson lesson : lessons){
			manager.persist(lesson);
		}
	}

	@Override
	public List<Lesson> queryLesson() {
		// TODO Auto-generated method stub
		String jpql="from Lesson les";
		List<Lesson> lessons=manager.createQuery(jpql).getResultList();
		return lessons;
	}

	@Override
	public List<Lesson> queryBlurLesson(String name) {
		// TODO Auto-generated method stub
		String jpql="from Lesson le where le.name like :name";
		List<Lesson> lessons=manager.createQuery(jpql)
				.setParameter("name", "%"+name+"%")
				.getResultList();
		return lessons;
	}

	@Override
	public Lesson queryOneLesson(String name) {
		// TODO Auto-generated method stub
		String jpql="from Lesson le where le.name=:name";
		List<Lesson> lessons=manager.createQuery(jpql)
				.setParameter("name", name)
				.getResultList();
		return lessons.get(0);
	}

}
