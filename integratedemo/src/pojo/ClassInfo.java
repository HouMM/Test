package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity   //表示该类能被hibernate持久化
@Table(name = "classInfo")   //指定该entity对应的数据表名
public class ClassInfo {
	
	@Id  //指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)  //主键类型，自动增长
	private Integer id;
	
	@Column(name = "semester_key")
    private String semester_key;
	
	@Column(name = "lesson_id")
    private String lesson_id;
	
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

	public String getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(String lesson_id) {
		this.lesson_id = lesson_id;
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

	public ClassInfo() {
    }

    public ClassInfo(String semester_key, String lesson_id , String title_info ,String class_info) {
        this.semester_key = semester_key;
        this.class_info = class_info;
        this.title_info = title_info;
        this.lesson_id = lesson_id;
    }


}
