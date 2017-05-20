package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //��ʾ�����ܱ�hibernate�־û�
@Table(name = "lesson")   //ָ����entity��Ӧ�����ݱ���
public class Lesson {
	
	@Id  //ָ������Ϊ����
	@GeneratedValue(strategy = GenerationType.AUTO)  //�������ͣ��Զ�����
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
