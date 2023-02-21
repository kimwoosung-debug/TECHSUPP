package com.example.repository;

import com.example.domain.Image;
import com.example.domain.ProductCheck;
import com.example.domain.ProductStatus;
import com.example.domain.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class ProductsRepositoryTest {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Commit
    @Transactional
    @Test
    public void 상품등록() {
        IntStream.rangeClosed(1,10).forEach(i -> {
            Products products = Products.builder()
                    .prodNm("Products" + i)
                    .price(100000 + i)
                    .prodContent("안녕하세요. 테스트 상품" + i + "입니다.")
                    .period(LocalDate.now()).build();
            productsRepository.save(products);

            int count = (int)(Math.random() * 5) + 1;

            for(int j = 0; j < count; j++) {
                Image image = Image.builder()
                        .uuid(UUID.randomUUID().toString())
                        .products(products)
                        .imgName("test" + j + ".jpg").build();
                imageRepository.save(image);
            }
        });

    }


}