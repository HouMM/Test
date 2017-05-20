package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClassInfoDAO;
import pojo.ClassInfo;
import service.ClassInfoManager;

@Service
public class ClassInfoManagerImpl implements ClassInfoManager{

	@Autowired
	private ClassInfoDAO classInfoDao;
	
	@Transactional
	@Override
	public void addClassInfo(List<ClassInfo> classInfos) {
		// TODO Auto-generated method stub
		classInfoDao.addClassInfo(classInfos);
	}

	@Transactional
	@Override
	public List<ClassInfo> queryClassInfo(String semester_key, String lesson_id) {
		// TODO Auto-generated method stub
		return classInfoDao.queryClassInfo(semester_key, lesson_id);
	}

}
