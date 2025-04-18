package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.TagDto;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.model.Tag;
import tadjik.ilyosjon.radios.repository.TagRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;

    public List<Tag> findAll() {
        return tagRepo.findAll();
    }

    public Tag findById(Integer id) {
        return tagRepo.findById(id).get();
    }

    public Result create(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tagRepo.save(tag);
        return new Result(true,"Tag created");
    }

    public Result update(Integer id, TagDto tagDto) {
        Optional<Tag> tagOptional = tagRepo.findById(id);
        if (tagOptional.isPresent()) {
            Tag tag = tagOptional.get();
            tag.setName(tagDto.getName());
            tagRepo.save(tag);
            return new Result(true,"Tag updated");
        }
        return new Result(false,"Tag not found");
    }

    public Result delete(Integer id) {
        tagRepo.deleteById(id);
        return new Result(true,"Tag deleted");
    }

}
