package tadjik.ilyosjon.radios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.radios.dto.CategoryDto;
import tadjik.ilyosjon.radios.dto.ProductDto;
import tadjik.ilyosjon.radios.model.Category;
import tadjik.ilyosjon.radios.model.Product;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Category> getall = categoryService.findAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Category service = categoryService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PostMapping
    public HttpEntity<?> create(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.create(categoryDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Result update = categoryService.update(id, categoryDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = categoryService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
