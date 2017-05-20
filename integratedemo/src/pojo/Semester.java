package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "semester")   //指定该entity对应的数据表名
public class Semester {
	
	@Id  //指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)  //主键类型，自动增长
	private Integer id;
	
	@Column(name = "se_key")
    private String se_key;
	
	@Column(name = "se_value")
    private String se_value;
	
	
	

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSe_key() {
		return se_key;
	}

	public void setSe_key(String se_key) {
		this.se_key = se_key;
	}

	public String getSe_value() {
		return se_value;
	}

	public void setSe_value(String se_value) {
		this.se_value = se_value;
	}

	public Semester() {

    }

    public Semester(String key, String value) {
        this.se_key = key;
        this.se_value = value;
    }
}
