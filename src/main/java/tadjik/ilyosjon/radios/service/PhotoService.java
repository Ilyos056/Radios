package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.PhotoDto;
import tadjik.ilyosjon.radios.model.Photo;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.PhotoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    PhotoRepo photoRepo;

    public List<Photo> getAll() {
        return photoRepo.findAll();
    }

    public Photo getById(Integer id) {
        return photoRepo.findById(id).get();
    }

    public Result create(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setName(photoDto.getName());
        photo.setSize(photoDto.getSize());
        photo.setPath(photoDto.getPath());
        photoRepo.save(photo);
        return new Result(true, "Photo created");
    }

    public Result update(Integer id, PhotoDto photoDto) {
        Optional<Photo> photoOptional = photoRepo.findById(id);
        if (photoOptional.isPresent()) {
            Photo photo = photoOptional.get();
            photo.setName(photoDto.getName());
            photo.setSize(photoDto.getSize());
            photo.setPath(photoDto.getPath());
            photoRepo.save(photo);
            return new Result(true, "Photo updated");
        }
        return new Result(false, "Photo not found");
    }

    public Result delete(Integer id) {
        photoRepo.deleteById(id);
        return new Result(true, "Photo deleted");
    }
}