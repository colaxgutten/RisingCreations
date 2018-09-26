package forum.risingcreations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.Tag;
import forum.risingcreations.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	TagRepository tagRepository;
	
	public Tag getTagByName(String name){
		Tag tag = tagRepository.findTagByTagName(name);
		if (tag==null) {
			tag = new Tag();
			tag.setTagName(name);
			saveTag(tag);
		}
		return tag;
	}
	
	public List<Tag> getTagsBySubName(String subname){
		List<Tag> tags = tagRepository.findTagByTagNameStartingWith(subname);
		return tags;
	}
	
	public void saveTag(Tag t) {
		tagRepository.save(t);
	}
	
}
