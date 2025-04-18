package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.AddresDto;
import tadjik.ilyosjon.radios.model.Addres;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.AddresRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AddresService {
    @Autowired
    AddresRepo addresRepo;

    //get all
    public List<Addres> getAll() {
        return addresRepo.findAll();
    }

    //get by id
    public Addres getById(Integer id) {
        return addresRepo.findById(id).get();
    }

    public Result create(AddresDto addresDto) {
        Addres addres = new Addres();
        addres.setCity(addresDto.getCity());
        addres.setStreet(addresDto.getStreet());
        addres.setZipcode(addresDto.getZipcode());
        addres.setHome_number(addresDto.getHome_number());
        addresRepo.save(addres);
        return new Result(true, "Addres created");
    }

    public Result update(Integer id, AddresDto addresDto) {
        Optional<Addres> addresOptional= addresRepo.findById(id);
        if (addresOptional.isPresent()) {
            Addres addres = addresOptional.get();
            addres.setCity(addresDto.getCity());
            addres.setStreet(addresDto.getStreet());
            addres.setZipcode(addresDto.getZipcode());
            addres.setHome_number(addresDto.getHome_number());
            addresRepo.save(addres);
            return new Result(true, "Addres updated");
        }
        return new Result(false, "Addres not found");
    }

    public Result delete(Integer id) {
        addresRepo.deleteById(id);
        return new Result(true, "Addres deleted");
    }


}
