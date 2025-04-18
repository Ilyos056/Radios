package tadjik.ilyosjon.radios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.radios.dto.CategoryDto;
import tadjik.ilyosjon.radios.dto.CheckoutDto;
import tadjik.ilyosjon.radios.model.Checkout;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.service.CheckoutService;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Checkout> getall = checkoutService.findAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Checkout service = checkoutService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PostMapping
    public HttpEntity<?> create(@RequestBody CheckoutDto checkoutDto) {
        Result result = checkoutService.create(checkoutDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody CheckoutDto checkoutDto) {
        Result update = checkoutService.update(id, checkoutDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = checkoutService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
