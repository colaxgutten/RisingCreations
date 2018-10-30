package forum.risingcreations.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import forum.risingcreations.models.Profile;
import forum.risingcreations.models.Tag;
import forum.risingcreations.services.ProfileService;
import forum.risingcreations.services.TagService;


@RestController
public class SearchRestController {
	
	@Autowired
	ProfileService profileService;
	@Autowired
	TagService tagService;
	
	
	@GetMapping("/search/autocomplete/profilename/{subname}")
	public String getProfileNamesStartingWith(@PathVariable("subname")String subname) {
		String[] names = profileService.findNamesStartingWith(subname);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString+= mapper.writeValueAsString(names);
		} catch (Exception e) {
			System.out.println("Didn't manage to write list of names as json-string");
		}
		return jsonString;
	}
	
	@GetMapping("/search/autocomplete/tag/{tagname}")
	public String getTagsBySubname(@PathVariable("tagname")String tagName) {
		String jsonString = "";
		List<Tag> tags = tagService.getTagsBySubName(tagName);
		if (tags!=null) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString += mapper.writeValueAsString((Object)tags);
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
		System.out.println("Searching for tags starting with: "+tagName +". Reult: "+jsonString);
		return jsonString;
	}
	
	@GetMapping("/search/profile/{profilename}")
	public String getProfileSearchResults(@PathVariable("profilename")String profilename) {
		List<Profile> result = Arrays.asList(profileService.findProfileByName(profilename));
		String jsonString = "";
		if (result!=null) {
			ObjectMapper mapper = new ObjectMapper();		
			try {
				jsonString +=mapper.writeValueAsString((Object)result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jsonString;
	}
}
