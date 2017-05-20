package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.SemesterDAO;
import pojo.Semester;
import service.SemesterManager;

@Service
public class SemesterManagerImpl implements SemesterManager{
	
	@Autowired
	private SemesterDAO semesterDao;

	@Transactional
	@Override
	public void addSemester(List<Semester> semesters) {
		// TODO Auto-generated method stub
		semesterDao.addSemester(semesters);
	}

	@Transactional
	@Override
	public List<Semester> querySemester() {
		// TODO Auto-generated method stub
		return semesterDao.querySemester();
	}

	@Transactional
	@Override
	public Semester queryOneSemester(String value) {
		// TODO Auto-generated method stub
		return semesterDao.queryOneSemester(value);
	}

}
