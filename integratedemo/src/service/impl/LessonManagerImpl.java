package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.LessonDAO;
import pojo.Lesson;
import service.LessonManager;

@Service
public class LessonManagerImpl implements LessonManager{
	
	@Autowired
	private LessonDAO lessonDao;

	@Transactional
	@Override
	public void addLesson(List<Lesson> lessons) {
		// TODO Auto-generated method stub
		lessonDao.addLesson(lessons);
	}

	@Transactional
	@Override
	public List<Lesson> queryLesson() {
		// TODO Auto-generated method stub
		return lessonDao.queryLesson();
	}

	@Transactional
	@Override
	public List<Lesson> queryBlurLesson(String name) {
		// TODO Auto-generated method stub
		return lessonDao.queryBlurLesson(name);
	}

	@Transactional
	@Override
	public Lesson queryOneLesson(String name) {
		// TODO Auto-generated method stub
		return lessonDao.queryOneLesson(name);
	}

}
