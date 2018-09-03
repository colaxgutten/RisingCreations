package forum.risingcreations.repositories;

import forum.risingcreations.models.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    public Profile findProfileByName(String name);

}
