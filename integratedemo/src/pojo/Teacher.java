package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")   //指定该entity对应的数据表名
public class Teacher {
	
	@Id  //指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)  //主键类型，自动增长
	private Integer id;
	
	@Column(name = "teacher_id")
    private String teacher_id;
    
	@Column(name = "name")
	private String name;

	
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher() {

    }

    public Teacher(String teacher_id, String name) {
        this.teacher_id = teacher_id;
        this.name = name;
    }
}
