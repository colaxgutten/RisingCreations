package forum.risingcreations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import forum.risingcreations.models.Profile;
import forum.risingcreations.services.ProfileService;


@RestController
public class SearchRestController {
	
	@Autowired
	ProfileService profileService;
	
	
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
	
	@GetMapping("/searh/profile/{profilename}")
	public String getProfileSearchResults(@PathVariable("profilename")String profilename) {
		Profile[] result = profileService.findProfileByName(profilename);
		String jsonString = "";
		if (result!=null) {
			ObjectMapper mapper = new ObjectMapper();		
			try {
				jsonString +=mapper.writeValueAsString(result);
			} catch (Exception e) {
				System.out.println("Didn't manage to write results as json-string");
			}
		}
		return jsonString;
	}
}
