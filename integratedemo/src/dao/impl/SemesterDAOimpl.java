package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.SemesterDAO;
import pojo.Semester;

@Repository
public class SemesterDAOimpl implements SemesterDAO {
	@PersistenceContext(name="mysql")
	private EntityManager manager;


	@Override
	public void addSemester(List<Semester> semesters) {
		// TODO Auto-generated method stub
		for(Semester semester : semesters){
			manager.persist(semester);
		}
	}

	@Override
	public List<Semester> querySemester() {
		// TODO Auto-generated method stub
		String jpql="from Semester";
		List<Semester> semesters=manager.createQuery(jpql).getResultList();
		return semesters;
	}

	@Override
	public Semester queryOneSemester(String value) {
		// TODO Auto-generated method stub
		String jpql="from Semester s where s.se_value =:se_value";
		List<Semester> semesters=manager.createQuery(jpql)
				.setParameter("se_value", value)
				.getResultList();
		return semesters.get(0);
	}
	
	

}
