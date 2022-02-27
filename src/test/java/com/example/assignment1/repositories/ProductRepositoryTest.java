package com.example.assignment1.repositories;

import com.example.assignment1.database.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("ค้นหาโดยใช้ Empty String, ได้ผลลัพธ์ทั้งหมด 10 รายการ")
    void findByName_with_emptyString() {
        // Arrange

        // Act
        List<Product> result = productRepository.findByName("");

        // Assert
        assertEquals(10, result.size());
    }

    @Test
    @DisplayName("ค้นหาโดยใช้ช่องว่าง, ได้ผลลัพธ์ทั้งหมด 10 รายการ")
    void findByName_with_whiteSpaceCharacter() {
        // Arrange

        // Act
        String name = "   ";
        List<Product> result = productRepository.findByName(name.trim());

        // Assert
        assertEquals(10, result.size());
    }

    @Test
    @DisplayName("ค้นหาโดยกรอกคำว่า adidas, ได้ผลลัพธ์ 3 รายการ")
    void findByName_with_adidasKeyword() {
        // Arrange

        // Act
        String name = "   adidas";
        List<Product> result = productRepository.findByName(name.trim());

        // Assert
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("ค้นหาโดยกรอกคำว่า zippo, ได้ผลลัพธ์ 0 รายการ")
    void findByName_with_emptyList() {
        // Arrange

        // Act
        String name = "zippo";
        List<Product> result = productRepository.findByName(name.trim());

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("ดูข้อมูลสินค้า id = -1, ได้ผลลัพธ์ 404 not found")
    void getById_with_invalidId() {
        // Arrange

        // Act
        Optional<Product> result = productRepository.findById(-1L);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("ดูข้อมูลสินค้า id = 2022, ได้ผลลัพธ์ 404 not found")
    void getById_with_notExistId() {
        // Arrange

        // Act
        Optional<Product> result = productRepository.findById(2022L);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("ดูข้อมูลสินค้า id = 9, ได้ข้อมูลสินค้าพัดลม")
    void getById_with_id9() {
        // Arrange

        // Act
        Optional<Product> result = productRepository.findById(9L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(9L, result.get().getId());
        assertTrue(result.get().getName().contains("พัดลมตั้งโต๊ะ"));
        assertFalse(result.get().getDetail().isEmpty());
    }
}