package tadjik.ilyosjon.radios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.radios.dto.ShopCardDto;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.model.ShopCard;
import tadjik.ilyosjon.radios.service.ShopCardService;

import java.util.List;

@RestController
@RequestMapping("/api/shopcard")
public class ShopCardController {
    @Autowired
    ShopCardService shopCardService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<ShopCard> getall = shopCardService.findAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        ShopCard service = shopCardService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PostMapping
    public HttpEntity<?> create(@RequestBody ShopCardDto shopCardDto) {
        Result result = shopCardService.create(shopCardDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody ShopCardDto shopCardDto) {
        Result update = shopCardService.update(id, shopCardDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = shopCardService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
