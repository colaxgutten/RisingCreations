package forum.risingcreations.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	String tagName;
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName=tagName;
	}
	
}
