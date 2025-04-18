package tadjik.ilyosjon.radios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.radios.dto.CategoryDto;
import tadjik.ilyosjon.radios.dto.PhotoDto;
import tadjik.ilyosjon.radios.model.Category;
import tadjik.ilyosjon.radios.model.Photo;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Photo> getall = photoService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Photo service = photoService.getById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PostMapping
    public HttpEntity<?> create(@RequestBody PhotoDto photoDto) {
        Result result = photoService.create(photoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody PhotoDto photoDto) {
        Result update = photoService.update(id, photoDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = photoService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
