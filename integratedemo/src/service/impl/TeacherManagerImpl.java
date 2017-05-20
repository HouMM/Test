package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TeacherDAO;
import pojo.Teacher;
import service.TeacherManager;

@Service
public class TeacherManagerImpl implements TeacherManager {
	
	@Autowired
	private TeacherDAO teacherDao;

	@Transactional
	@Override
	public void addTeacher(List<Teacher> teachers) {
		// TODO Auto-generated method stub
		teacherDao.addTeacher(teachers);
	}

	@Transactional
	@Override
	public List<Teacher> queryTeacher() {
		// TODO Auto-generated method stub
		return teacherDao.queryTeacher();
	}

	@Transactional
	@Override
	public List<Teacher> queryBlurTeacher(String name) {
		// TODO Auto-generated method stub
		return teacherDao.queryBlurTeacher(name);
	}

	@Transactional
	@Override
	public Teacher queryOneTeacher(String id) {
		// TODO Auto-generated method stub
		return teacherDao.queryOneTeacher(id);
	}

}
