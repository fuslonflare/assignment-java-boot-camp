package com.example.assignment1.services;

import com.example.assignment1.database.Product;
import com.example.assignment1.database.UserBasket;
import com.example.assignment1.models.AddProductInfoItem;
import com.example.assignment1.models.AddProductToBasketRequest;
import com.example.assignment1.repositories.ProductRepository;
import com.example.assignment1.repositories.UserBasketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserBasketServiceTest {

    @Mock
    private UserBasketRepository userBasketRepository;

    @Mock
    private ProductRepository productRepository;

    private final UserBasketService userBasketService = new UserBasketService();
    private void setup() {
        userBasketService.setUserBasketRepository(userBasketRepository);
        userBasketService.setProductRepository(productRepository);
    }

    @Test
    void addToBasket_with_nullRequest() {
        // Arrange
        setup();

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(null);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("request is required.", errorMessage);
    }

    @Test
    void addToBasket_with_emptyRequest() {
        // Arrange
        setup();

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(new AddProductToBasketRequest());
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("userId is required", errorMessage);
    }

    @Test
    void addToBasket_with_invalidUserId() {
        // Arrange
        setup();
        AddProductToBasketRequest request = new AddProductToBasketRequest(null, -1);

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("userId is required", errorMessage);
    }

    @Test
    void addToBasket_with_nullAddProductInfo() {
        // Arrange
        setup();
        AddProductToBasketRequest request = new AddProductToBasketRequest(null, 1);

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("addProductInfos is required.", errorMessage);
    }

    @Test
    void addToBasket_with_emptyAddProductInfo() {
        // Arrange
        setup();
        AddProductToBasketRequest request = new AddProductToBasketRequest(new ArrayList<>(), 1);

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("addProductInfos is required.", errorMessage);
    }

    @Test
    void addToBasket_with_addProductInfo_invalidAmount() {
        // Arrange
        setup();
        List<AddProductInfoItem> addProductInfoItemList = new ArrayList<>();
        addProductInfoItemList.add(new AddProductInfoItem(-1, 1));
        addProductInfoItemList.add(new AddProductInfoItem(1, 2));
        AddProductToBasketRequest request = new AddProductToBasketRequest(addProductInfoItemList, 1);

        // Act
        String errorMessage = null;
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertEquals("amount is invalid", errorMessage);
    }

    @Test
    void addToBasket_with_addProductInfo_invalidProductId() {
        // Arrange
        setup();

        List<Product> allProducts = new ArrayList<>();
        Product product1 = new Product(
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
        product1.setId(9L);

        Product product2 = new Product(
                "Zally Crop Top - Labotte.clothing เสื้อผ้าร่องใส่สบาย",
                "https://cf.shopee.co.th/file/925e90712baf8b2fe399e8dc70082f14",
                350d, 350d, 4.9d,
                "Zally Crop Top\uD83E\uDD0D เสื้อครอปที่มีดีเทลเชือกสุดพิเศษที่ด้านหลัง สามารถปรับขนาด ผูกแบบไหนก้ได้และเปลี่ยนเชือกได้น้า (มีให้ 2 สี) จะใส่อยู่บ้านหรือใส่ไปข้างนอกก็ได้หมดเลย\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC95 เพราะผ้าเราใส่สบายมากๆ ดีเทลด้านหน้าให้ความรู้สึกเรียบหรู ส่วนด้านหลังคือปังมากกกก มีสไตล์แบบไม่เหมือนใครแน่นอนค้า ชิคสุดด\uD83D\uDCAF\uD83D\uDCA5\n" +
                        "\n" +
                        "รุ่นนี้เราใช้ผ้าร่องคุณภาพดีเข้ากับดีไซน์สุดพิเศษจากดีไซน์เน้อของเราที่ต้องการทำเสื้อ Crop ตัวนี้ออกมา สวย เก็บทรงมาก ยืดได้ถึงอก “38 หวังว่าทุกคนจะได้ลองใส่กันน้าา\uD83D\uDE1D\uD83D\uDC95\n" +
                        "\n" +
                        "Zally Crop Top✨\n" +
                        "Price: 350\n" +
                        "Size: Freesize\n" +
                        "Color: Milky, Vanilla, Choco, Charcoal \n" +
                        "\n" +
                        "\uD83D\uDCA5CODE\uD83D\uDCA5\n" +
                        "\n" +
                        "\uD83D\uDD25กรอกช่องส่วนลดของช้อปปี้ โค้ด WSCETE ลดทันที 125.- เมื่อช้อปครบ 350.-\n" +
                        "\n" +
                        "⏰ โค้ดนี้ใช้ได้ตั้งเเต่ วันนี้ - 30 กย. หรือก่อนโค้ดจะหมด",
                15, 114,
                LocalDateTime.now(), LocalDateTime.now()
        );
        product2.setId(8L);

        allProducts.add(product1);
        allProducts.add(product2);
        when(productRepository.findAll()).thenReturn(allProducts);

        List<AddProductInfoItem> items = new ArrayList<>();
        items.add(new AddProductInfoItem(1, 1L));
        items.add(new AddProductInfoItem(1, 10L));
        AddProductToBasketRequest request = new AddProductToBasketRequest(items, 1L);

        String errorMessage = null;

        // Act
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertNotNull(errorMessage);
        assertEquals("productId is invalid", errorMessage);
    }

    @Test
    void addToBasket_with_addProductInfo_amountMoreThanStock() {
        // Arrange
        setup();

        List<Product> allProducts = new ArrayList<>();
        Product product1 = new Product(
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
        product1.setId(9L);

        Product product2 = new Product(
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
        );
        product2.setId(10L);

        allProducts.add(product1);
        allProducts.add(product2);
        when(productRepository.findAll()).thenReturn(allProducts);

        List<AddProductInfoItem> items = new ArrayList<>();
        items.add(new AddProductInfoItem(2, 9L));
        items.add(new AddProductInfoItem(80, 10L));
        AddProductToBasketRequest request = new AddProductToBasketRequest(items, 1L);

        String errorMessage = null;

        // Act
        try {
            userBasketService.addProductToBasket(request);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertNotNull(errorMessage);
        assertEquals("amount cannot be more than stock", errorMessage);
    }
}