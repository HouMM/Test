package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //表示该类能被hibernate持久化
@Table(name = "lesson")   //指定该entity对应的数据表名
public class Lesson {
	
	@Id  //指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)  //主键类型，自动增长
	private Integer id;
	
	@Column(name = "lesson_id")
    private String lesson_id;
	
	@Column(name = "name")
    private String name;
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(String lesson_id) {
		this.lesson_id = lesson_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lesson() {

    }

    public Lesson(String lesson_id, String name) {
        this.lesson_id = lesson_id;
        this.name = name;
    }
}
