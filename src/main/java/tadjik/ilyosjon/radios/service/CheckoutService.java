package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerMapping;
import tadjik.ilyosjon.radios.dto.CheckoutDto;
import tadjik.ilyosjon.radios.model.Addres;
import tadjik.ilyosjon.radios.model.Checkout;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.AddresRepo;
import tadjik.ilyosjon.radios.repository.CheckoutRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    @Autowired
    CheckoutRepo checkoutRepo;

    @Autowired
    AddresRepo addresRepo;


    public List<Checkout> findAll() {
        return checkoutRepo.findAll();
    }

    public Checkout findById(Integer id) {
        return checkoutRepo.findById(id).get();
    }

    //create
    public Result create(CheckoutDto checkoutDto) {
        Checkout checkout = new Checkout();
        checkout.setFirstName(checkoutDto.getFirstName());
        checkout.setLastName(checkoutDto.getLastName());
        checkout.setCompany_name(checkoutDto.getCompany_name());
        checkout.setEmail(checkoutDto.getEmail());
        checkout.setPhone(checkoutDto.getPhone());

        Optional<Addres> addresOptional = addresRepo.findById(checkoutDto.getAddres_id());
        Addres addres = addresOptional.get();
        checkout.setAddres_id((List<Addres>) addres);

        checkout.setPassword(checkoutDto.getPassword());
        checkout.setNotes(checkoutDto.getNotes());

        checkoutRepo.save(checkout);
        return new Result(true, "Checkout created");
    }

    //update
    public Result update(Integer id, CheckoutDto checkoutDto) {
        Optional<Checkout> checkoutOptional = checkoutRepo.findById(id);
        if (checkoutOptional.isPresent()) {
            Checkout checkout = checkoutOptional.get();
            checkout.setFirstName(checkoutDto.getFirstName());
            checkout.setLastName(checkoutDto.getLastName());
            checkout.setCompany_name(checkoutDto.getCompany_name());
            checkout.setEmail(checkoutDto.getEmail());
            checkout.setPhone(checkoutDto.getPhone());

            Optional<Addres> optionalAddres = addresRepo.findById(id);
            Addres addres = optionalAddres.get();
            checkout.setAddres_id((List<Addres>) addres);

            checkout.setPassword(checkoutDto.getPassword());
            checkout.setNotes(checkoutDto.getNotes());
            checkoutRepo.save(checkout);
            return new Result(true, "Checkout updated");
        }
        return new Result(false, "Checkout not found");
    }

    //delete
    public Result delete(Integer id) {
        Optional<Checkout> checkoutOptional = checkoutRepo.findById(id);
        if (checkoutOptional.isPresent()) {
            checkoutRepo.deleteById(id);
            return new Result(true, "Checkout deleted");
        }
        return new Result(false, "Checkout not found");
    }

}
