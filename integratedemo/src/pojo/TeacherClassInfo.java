package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacherClassInfo")
public class TeacherClassInfo {
	
	@Id  //指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)  //主键类型，自动增长
	private Integer id;
	
	@Column(name = "semester_key")
	private String semester_key;
	
	@Column(name = "teacher_id")
	private String teacher_id;
	
	@Column(name = "title_info")
	private String title_info;
	
	@Column(name = "class_info")
	private String class_info;
	
	

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemester_key() {
		return semester_key;
	}

	public void setSemester_key(String semester_key) {
		this.semester_key = semester_key;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTitle_info() {
		return title_info;
	}

	public void setTitle_info(String title_info) {
		this.title_info = title_info;
	}

	public String getClass_info() {
		return class_info;
	}

	public void setClass_info(String class_info) {
		this.class_info = class_info;
	}

	public TeacherClassInfo() {
    }

    public TeacherClassInfo(String semester_key, String teacher_id , String title_info , String class_info) {
        this.semester_key = semester_key;
        this.teacher_id = teacher_id;
        this.title_info = title_info;
        this.class_info = class_info;
    }
}
