package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.ProfileDto;
import tadjik.ilyosjon.radios.model.Profile;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    public Profile findById(Integer id) {
        return profileRepo.findById(id).get();
    }

    public Result create(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPassword(profileDto.getPassword());
        profileRepo.save(profile);
        return new Result(true,"Profile created");
    }

    public Result update(Integer id, ProfileDto profileDto) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPassword(profileDto.getPassword());
            profileRepo.save(profile);
            return new Result(true,"Profile updated");
        }
        return new Result(false,"Profile not found");
    }

    public Result delete(Integer id) {
        profileRepo.deleteById(id);
        return new Result(true,"Profile deleted");
    }

}
