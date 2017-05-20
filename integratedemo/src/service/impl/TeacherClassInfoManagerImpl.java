package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TeacherClassInfoDAO;
import pojo.TeacherClassInfo;
import service.TeacherClassInfoManager;

@Service
public class TeacherClassInfoManagerImpl implements TeacherClassInfoManager{
	
	@Autowired
	private TeacherClassInfoDAO teacherClassInfoDao;

	@Transactional
	@Override
	public void addteacherClassInfo(List<TeacherClassInfo> teacherClassInfos) {
		// TODO Auto-generated method stub
		teacherClassInfoDao.addteacherClassInfo(teacherClassInfos);
	}

	@Transactional
	@Override
	public List<TeacherClassInfo> queryteacherClassInfo(String semester_key, String teacher_id) {
		// TODO Auto-generated method stub
		return teacherClassInfoDao.queryteacherClassInfo(semester_key, teacher_id);
	}

}
