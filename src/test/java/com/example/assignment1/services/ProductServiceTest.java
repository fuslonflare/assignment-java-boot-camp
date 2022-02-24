package com.example.assignment1.services;

import com.example.assignment1.database.Product;
import com.example.assignment1.models.BaseSearchResultModel;
import com.example.assignment1.models.ProductFilter;
import com.example.assignment1.models.ProductInfo;
import com.example.assignment1.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private void initialData() {
        List<Product> entities = new ArrayList<>();
        entities.add(new Product(
                "adidas Essentials Gradient Anorak Windbreaker ผู้หญิง สีดำ GM5594",
                "https://cf.shopee.co.th/file/6a252cfca2adce58a6494e42a62a08bd_tn",
                2300d, 1288d, 4.9d,
                "Don't let a little wind wreck your afternoon. This adidas jacket has a half zip and a hood for all the coverage that you need. It features AEROREADY that manages moisture and keeps you dry.\n" +
                        "\n" +
                        "This product is made with recycled content as part of our ambition to end plastic waste.\n" +
                        "- Half zip with drawcord-adjustable hood\n" +
                        "- 76% recycled polyester, 24% polyester seersucker\n" +
                        "- Moisture absorbing\n" +
                        "- Regular fit",
                59, 78,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
                "adidas ORIGINALS Forum Low Shoes ผู้หญิง สีขาว Sneaker GX5072",
                "https://cf.shopee.co.th/file/de1ed3461d9ca6dfe649857946b8965d_tn",
                3000d, 1680d, 5d,
                "Sport and style go hand in hand. Just ask any pro basketball player. Inspired by the sought-after trainer from '84, these adidas Forum Low Shoes bring B-ball swagger to your everyday look thanks to chic satin details. The iconic leather upper and hook-and-loop ankle strap pay tribute to the greats who have been rocking the Forum since day one. \n" +
                        " \n" +
                        " This product is made with recycled content as part of our ambition to end plastic waste. 20% of pieces used to make the upper are made with minimum 50% recycled content.\n" +
                        "- Lace closure with hook-and-loop strap\n" +
                        "- Leather upper with satin underlays\n" +
                        "- Elastane lining\n" +
                        "- Jersey sockliner\n" +
                        "- Rubber outsole\n" +
                        "- Regular fit\n" +
                        "- COATED LEATHER/TEXTILE",
                26, 75,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
                "adidas ORIGINALS รองเท้า ZX 2K Boost ผู้หญิง สีเทา Sneaker FY0606",
                "https://cf.shopee.co.th/file/260dab0ed90b486cd3ffa000405177e4",
                4600d, 2576d, 5d,
                "รองเท้า ZX 2K Boost ที่ได้แรงบันดาลใจจากเทคโนโลยีล้ำสมัยของอาดิดาสคู่นี้จะช่วยให้คุณก้าวผ่านเข้าสู่โลกดิจิทัล วินาทีที่สวมใส่ก็เหมือนได้เข้าไปอยู่ในอีกมิติหนึ่งแล้ว ทั้งเชื่อมโยงกันยิ่งขึ้นและน่าสนใจยิ่งกว่า ไอเดียทั้งหลายได้หลั่งไหลเข้ามาอยู่ในรองเท้าคู่นี้หมดแล้ว\n" +
                        "- มีเชือกผูกรองเท้า\n" +
                        "- อัปเปอร์ทำจากผ้าตาข่าย แต่งโอเวอร์เลย์ทีพียู\n" +
                        "- รองเท้าที่รองรับเท้าและตอบสนองได้ดี",
                11, 14,
                LocalDateTime.now(), LocalDateTime.now()
        ));

        when(productRepository.findByName("adidas")).thenReturn(entities);
    }

    private void initialEmptyData() {
        when(productRepository.findByName("woohoo")).thenReturn(new ArrayList<>());
    }

    @Test
    void search_with_notFound_page1_itemPerPage20() {
        // Arrange
        initialEmptyData();

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        ProductFilter filter = new ProductFilter(1, 20, "woohoo");

        // Act
        BaseSearchResultModel<ProductInfo> actualResult = productService.search(filter);

        // Assert
        assertEquals(0, actualResult.getItems().size());
        assertEquals(0, actualResult.getTotalPage());
        assertEquals(0, actualResult.getTotalItems());
    }

    @Test
    void search_with_page1_itemPerPage1() {
        // Arrange
        initialData();

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        ProductFilter filter = new ProductFilter(1, 1, "adidas");

        // Act
        BaseSearchResultModel<ProductInfo> actualResult = productService.search(filter);

        // Assert
        assertEquals(1, actualResult.getItems().size());
        assertEquals(3, actualResult.getTotalPage());
        assertEquals(3, actualResult.getTotalItems());
    }

    @Test
    void search_with_page1_itemPerPage20() {
        // Arrange
        initialData();

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        ProductFilter filter = new ProductFilter(1, 20, "adidas");

        // Act
        BaseSearchResultModel<ProductInfo> actualResult = productService.search(filter);

        // Assert
        assertEquals(3, actualResult.getItems().size());
        assertEquals(1, actualResult.getTotalPage());
        assertEquals(3, actualResult.getTotalItems());
    }

    @Test
    void search_with_page3_itemPerPage20() {
        // Arrange
        initialData();

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        ProductFilter filter = new ProductFilter(3, 20, "adidas");

        // Act
        BaseSearchResultModel<ProductInfo> actualResult = productService.search(filter);

        // Assert
        assertEquals(0, actualResult.getItems().size());
        assertEquals(1, actualResult.getTotalPage());
        assertEquals(3, actualResult.getTotalItems());
    }

    @Test
    void search_with_page2_itemPerPage2() {
        // Arrange
        initialData();

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        ProductFilter filter = new ProductFilter(2, 2, "adidas");

        // Act
        BaseSearchResultModel<ProductInfo> actualResult = productService.search(filter);

        // Assert
        assertEquals(1, actualResult.getItems().size());
        assertEquals(2, actualResult.getTotalPage());
        assertEquals(3, actualResult.getTotalItems());
    }

    @Test
    void get_with_invalidId() {
        // Arrange
        when(productRepository.findById(-1L)).thenReturn(Optional.empty());

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        // Act
        ProductInfo result = productService.get(-1L);

        // Assert
        assertNull(result);
    }

    @Test
    void get_with_notExistId() {
        // Arrange
        when(productRepository.findById(2022L)).thenReturn(Optional.empty());

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        // Act
        ProductInfo result = productService.get(2022L);

        // Assert
        assertNull(result);
    }

    @Test
    void get_with_id9() {
        // Arrange
        Product product = new Product(
                "Kashiwa พัดลมตั้งโต๊ะ (คละสี) ขนาด 6 นิ้ว รุ่น KW-07 พัดลมตั้งโต๊ะ พัดลมตัวเล็ก",
                "https://cf.shopee.co.th/file/712e528da2814c08153e94f784ff89e4",
                599d, 179d, 4.3d,
                "คุณสมบัติ\n" +
                        "- พัดลมตั้งโต๊ะ 6 นิ้ว  เล็กกะทัดรัด พกพาสะดวก \n" +
                        "- เหมาะสำหรับการระบายความร้อนส่วนบุคคลในระยะใกล้ๆ\n" +
                        "- ปรับความแรงของพัดลมได้ 2 ระดับ \n" +
                        "- สามารถปรับก้มเงยหน้าพัดลมได้\n" +
                        "- สามารถวางไว้บนชั้นวางหรือบนโต๊ะ\n" +
                        "- กำลังไฟฟ้า 25 วัตต์\n" +
                        "- ขนาดสินค้า : 20 x 17 x 27 cm. ",
                9, 42,
                LocalDateTime.now(), LocalDateTime.now()
        );
        product.setId(9L);
        when(productRepository.findById(9L)).thenReturn(Optional.of(product));

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        // Act
        ProductInfo result = productService.get(9L);

        // Assert
        assertNotNull(result);
        assertEquals(9L, result.getId());
        assertTrue(result.getName().contains("พัดลมตั้งโต๊ะ"));
        assertTrue(result.getDiscount() > 0d);
        assertFalse(result.getDetail().isEmpty());
    }
}