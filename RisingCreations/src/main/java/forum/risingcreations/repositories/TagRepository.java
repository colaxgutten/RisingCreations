package forum.risingcreations.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import forum.risingcreations.models.Tag;

public interface TagRepository extends CrudRepository<Tag,Long> {
	
	public Tag findTagByTagName(String tagName);
	
	public List<Tag> findTagByTagNameStartingWith(String subname);
}
