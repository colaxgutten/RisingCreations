package forum.risingcreations.services;

import forum.risingcreations.models.Profile;
import forum.risingcreations.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile findProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile[] findProfileByName(String name) {
    	
        return profileRepository.findProfileByName(name);
    }
    
    public void saveProfile(Profile profile) {
    	profileRepository.save(profile);
    }

	public String[] findNamesStartingWith(String subname) {
		Profile[] profiles =profileRepository.findProfileByNameStartingWith(subname);
		String[] names = null;
		if (profiles!=null) {
			names = new String[profiles.length];
			for (int i = 0;i<profiles.length;i++) {
				names[i]=profiles[i].getName();
			}
		}
		return names;
	}
}
