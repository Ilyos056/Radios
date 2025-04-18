package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.ShopCardDto;
import tadjik.ilyosjon.radios.model.Photo;
import tadjik.ilyosjon.radios.model.Product;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.model.ShopCard;
import tadjik.ilyosjon.radios.repository.PhotoRepo;
import tadjik.ilyosjon.radios.repository.ProductRepo;
import tadjik.ilyosjon.radios.repository.ShopCardRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ShopCardService {

    @Autowired
    ShopCardRepo shopCardRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PhotoRepo photoRepo;

    public List<ShopCard> findAll() {
        return shopCardRepo.findAll();
    }

    public ShopCard findById(Integer id) {
        return shopCardRepo.findById(id).get();
    }

    public Result create(ShopCardDto shopCartDto) {
        ShopCard shopCart = new ShopCard();

        Optional<Photo> optionalPhoto = photoRepo.findById(shopCartDto.getPhotoId());
        Photo photo = optionalPhoto.get();
        shopCart.setPhotoId((Photo) photo);

        Optional<Product> optionalProduct = productRepo.findById(shopCartDto.getProductId());
        Product product = optionalProduct.get();
        shopCart.setProductId((List<Product>) product);

        shopCart.setPrice(product.getPrice());
        shopCart.setQuantity(shopCartDto.getQuantity());
        shopCart.setTotal(shopCartDto.getTotal());
        shopCart.setCoupon(shopCartDto.getCoupon());
        shopCart.setShipping(shopCartDto.getShipping());
        shopCardRepo.save(shopCart);
        return new Result(true, "ShopCart added successfully");
    }

    public Result update(Integer id, ShopCardDto shopCartDto) {
        Optional<ShopCard> optionalShopCart = shopCardRepo.findById(id);
        if (optionalShopCart.isPresent()) {
            ShopCard shopCart = optionalShopCart.get();

            Optional<Photo> optionalPhoto = photoRepo.findById(shopCartDto.getProductId());
            Photo photo = optionalPhoto.get();
            shopCart.setPhotoId((Photo) photo);

            Optional<Product> optionalProduct = productRepo.findById(shopCartDto.getProductId());
            Product product = optionalProduct.get();
            shopCart.setProductId((List<Product>) product);

            shopCart.setPrice(product.getPrice());
            shopCart.setQuantity(shopCartDto.getQuantity());
            shopCart.setTotal(shopCartDto.getTotal());
            shopCart.setCoupon(shopCartDto.getCoupon());
            shopCart.setShipping(shopCartDto.getShipping());
            shopCardRepo.save(shopCart);
            return new Result(true, "shpCart updated successfully");
        }
        return new Result(false, "ShopCart not found");
    }

    public Result delete(Integer id) {
        Optional<ShopCard> optionalShopCart = shopCardRepo.findById(id);
        if (optionalShopCart.isPresent()) {
            shopCardRepo.deleteById(id);
            return new Result(true, "ShopCart deleted successfully");
        }
        return new Result(false, "ShopCart not found");
    }


}
