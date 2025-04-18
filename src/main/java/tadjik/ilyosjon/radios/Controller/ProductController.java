package tadjik.ilyosjon.radios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.radios.dto.ProductDto;
import tadjik.ilyosjon.radios.model.Product;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Product> getall = productService.findAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Product service = productService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PostMapping
    public HttpEntity<?> create(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.create(id, productDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result update = productService.update(id, productDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN' , 'MODERATOR')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = productService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
