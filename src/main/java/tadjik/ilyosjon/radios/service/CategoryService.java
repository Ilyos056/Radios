package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.CategoryDto;
import tadjik.ilyosjon.radios.model.Category;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto CategoryDto) {
        Category category = new Category();
        category.setName(CategoryDto.getName());
        category.setDescription(CategoryDto.getDescription());
        categoryRepo.save(category);
        return new Result(true, "Category created");
    }

    public Result update(Integer id, CategoryDto CategoryDto) {
        Category category = new Category();
        category.setId(id);
        category.setName(CategoryDto.getName());
        category.setDescription(CategoryDto.getDescription());
        categoryRepo.save(category);
        return new Result(true, "Category updated");
    }

    public Result delete(Integer id) {
        categoryRepo.deleteById(id);
        return new Result(true, "Category deleted");
    }
}
