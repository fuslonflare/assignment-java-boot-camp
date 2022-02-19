package com.example.assignment1.repositories;

import com.example.assignment1.database.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
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
        entities.add(new Product(
                "Bentoy(9572-1)เสื้อครอปแขนสั่น ไหมพรม คอกลม สีพื้นน่ารัก",
                "https://cf.shopee.co.th/file/a8e0e484b6c9d9e7e9830129ee20c9b8",
                199d, 89d, 4.8d,
                "Bentoy(9572-1)เสื้อครอปแขนสั่น ไหมพรม คอกลม สีพื้นน่ารัก\n" +
                        "\n",
                180, 119,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
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
        ));
        entities.add(new Product(
                "เสื้อครอปกลัดอกมัดใจ (แบบสั้น) ใส่สบาย ไม่รัดรักแร้",
                "https://cf.shopee.co.th/file/41fa619e3ec4215d64b8c019bd7aaee1",
                115d, 96d, 4.9d,
                "เสื้อรุ่น ครอปสั้นมัดใจ \uD83D\uDC85\uD83C\uDFFB\uD83C\uDF4B#งานมือ1\n" +
                        "มี 6 สี นมเย็น ครีมชมพู ชมพูขับผิว สีดำ และสีขาว \uD83C\uDF10\n" +
                        "มีผ่า 3 แบบ\n" +
                        "-ผ่าทั้งตัว\n" +
                        "-ผ่าครึ่งอก\n" +
                        "-ผ่าผสม\n" +
                        "\n" +
                        "ขนาดอก\n" +
                        "สีนมเย็น\uD83D\uDC5A: อกถึง 42 นิ้ว ยาว 14.5 นิ้ว รอบแขน 30 เซนติเมตร\n" +
                        "สีขาว \uD83C\uDF73: อกถึง 38 นิ้ว ยาว 14.5 นิ้ว รอบแขน 30 เซนติเมตร\n" +
                        "สีดำ\uD83E\uDD8B: อกถึง 38 นิ้ว ยาว 14.5 นิ้ว รอบแขน 28 เซนติเมตร\n" +
                        "สีฟ้า\uD83C\uDF80: อกถึง 42 นิ้ว ยาว 14.5 นิ้ว รอบแขน 30 เซนติเมตร\n" +
                        "สีม่วง\uD83C\uDF3C: อกถึง 42 นิ้ว ยาว 14.5 นิ้ว รอบแขน 40 เซนติเมตร\n" +
                        "สีชมพูขับผิว\uD83D\uDC96: อกถึง 40 นิ้ว ยาว 14.5 นิ้ว รอบแขน 36 เซนติเมตร\n" +
                        "สีครีมชมพู\uD83C\uDF6C: อกถึง 44 นิ้ว ยาว 14.5 นิ้ว รอบแขน 40 เซนติเมตร\n" +
                        "\n" +
                        "Price: 115 ฿\n" +
                        "\n" +
                        "#เสื้อครอป #ครอป #เสื้อdiy #เสื้อแฟชั่น #เสื้อยืด #เสื้อครอปกลัดอก",
                69, 84,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
                "ชุดตรวจโควิด ATK GICA แท้100%ผ่านมาตรฐานการรับรองจาก อย.✅",
                "https://cf.shopee.co.th/file/90f158370854bc38125aa09d08e918cb",
                62d, 62d, 4.8d,
                "\uD83E\uDDA0ยี่ห้อ\u200BGica\u200B Testsealabs\uD83E\uDDECฆพ.1464/2564\n" +
                        "\uD83D\uDCDCมี อย.ไทย ถูกต้องสามารถเช็คได้ (T6400358)และ (T64000397)\n" +
                        "\uD83D\uDCD6ฉลากและคู่มืออย่างละเอียดเป็นภาษาไทย\n" +
                        "อุปกรณ์ครบชุด ใช้ง่าย รู้ผลเร็ว มีความแม่นยำสูง ผลตรวจวิเคราะห์น่าเชื่อถือ และเป็นที่ยอมรับ\n" +
                        "\uD83D\uDCE6กล่องบรรจุ 1 เทส ใช้ได้ 1 ครั้ง\n" +
                        "➡️ใช้งานง่ายไม่เจ็บตัว\u200B ทั้ง\u200Bเด็ก\u200B \u200Bและ\u200B ผู้ใหญ่\u200B\n" +
                        "✔️ของแท้\u200B100%มีคิวอาร์โค้ด\u200Bตรวจ\u200Bสอบเช็ค\u200Bรายละเอียด\u200B\n" +
                        "\n" +
                        "✔️ชุด\u200Bตรวจ\u200Bมาตรฐาน\u200Bยุโรป\u200B เยอรมัน\u200B EU.\u200B CE.  ISO มีใบรั\u200Bบรองจากหลา\u200Bย\u200Bสถาบัน\u200Bต่างๆ\u200Bได้รับ\u200Bการทดสอ\u200Bบจากมหาลัย\u200Bมหิดล\n" +
                        "✔️ความแม่นยำ\u200B98.4\u200B%\n" +
                        "\n" +
                        "✅H-Guard แบบแยงจมูก ได้มาตรฐานสากล \n" +
                        "✅Giga:จิก้า  แบบ2in1 ใช้ได้ทั้งแหย่จมูก&น้ำลาย\n" +
                        "#สินค้าพร้อมส่ง \n" +
                        "ATK",
                79, 720,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
                "เสื้อผ้าฝ้ายคอกลมป้าย เนื้อผ้านุ่ม รีดง่าย",
                "https://cf.shopee.co.th/file/1c2ad44f5709734afdd5548e18b5c51d",
                160d, 160d, 4.8d,
                "\uD83E\uDD66\uD83E\uDD66ส่งของทุกวัน ตัดยอดเที่ยงนะคะ\uD83E\uDD66\n" +
                        "\uD83D\uDC49เสื้อผ้าฝ้ายคอกลมป้ายแต่งผ้านากา\uD83D\uDC48\n" +
                        "รอบอก 36/38/40/42นิ้ว\n" +
                        "ความยาว 19-21นิ้ว\n" +
                        " ❤❤ ราคาปลีก 160 บาท ❤❤ \n" +
                        "▶️ มีสี : กรม ขาว เเดงเลือดหมู ชมพู ชมพูกะปิ เขียว เหลือง\n" +
                        "▶️ เนื้อผ้า : ผ้าพื้นเมืองเชียงใหม่\n" +
                        "งานเสื้อป้ายคอกลม ใส่เที่ยวได้และทำงานได้ เรียบๆสวยๆ ใส่ไม่ร้อน \n" +
                        "\uD83C\uDF37\uD83C\uDF37 มีราคาส่งและราคาปลีก \uD83C\uDF37\uD83C\uDF37\n" +
                        "(ราคาส่ง 30 ตัวขึ้นไป คละแบบได้ทั้งร้าน //ราคาแล้วแต่แบบ)\n" +
                        "\n" +
                        "\n" +
                        "หมายเหตุ\n" +
                        "\uD83D\uDC49ผ้าใหม่ให้ซักแยก อาจมีสีส่วนเกินตกในน้ำ1-2แรก\n" +
                        "\uD83D\uDC49ซักปกติไม่ต้องแช่ทิ้งไว้ และรีดจากด้านใน\n" +
                        "\uD83D\uDC49สินค้าซื้อแล้ว ไม่รับเปลี่ยน/คืน นอกจากทางร้านส่งผิดรุ่น ผิดไซต์\n" +
                        "\uD83D\uDC49 กรุณาเช็คสินค้าก่อน ว่ามีตำหนิรึป่าวก่อนซักด้วยนะคะ\n" +
                        "\n" +
                        "**กรุณาบวก/ลบ 1-2นิ้ว เพราะช่างเย็บลึกตื้นต่างกัน\n" +
                        "\n" +
                        "\n" +
                        "#มุกดาผ้าฝ้าย #ผ้าฝ้าย #ผ้าพื้นเมือง #เสื้อทำงาน  #แฟชั่นผ้าเหนือ #เสื้อเมือง #ชุดพื้นเมือง #เสื้อเหนือ #รีวิวเชียงใหม่ #ผ้าฝ้ายทันสมัย  #เสื้อทำงาน #แฟชั่นล้านนา #ชุดพื้นเมืองราคาส่ง  #ขายส่ง #เสื้อผ้าราคาเบาๆ #เสื้อผ้าฝ้าย #เสื้อผ้าราคาถูก",
                660, 115,
                LocalDateTime.now(), LocalDateTime.now()
        ));
        entities.add(new Product(
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
        ));
        entities.add(new Product(
                "โต๊ะญี่ปุ่นอย่างดี โต๊ะอ่านหนังสือ โต๊ะอเนกประสงค์ โต๊ะนั่งพื้น",
                "https://cvf.shopee.co.th/file/KQ4ChMG-XPm-srTD",
                190d, 125d, 4.8d,
                "****** ขนาดสินค้า ******\n" +
                        "\n" +
                        "ความยาว 60 เซนติเมตร\n" +
                        "ความกว้าง 40 เซนติเมตร \n" +
                        "สูงจากพื้น  27.5 เซนติเมตร \n" +
                        "\n" +
                        "****** คุณลักษณะ ******\n" +
                        "ขาพับได้\n" +
                        "มีที่วางแก้วน้ำ\n" +
                        "มีที่ตั้ง tabled\n" +
                        "\n" +
                        "**โฟมกันลื่นเป้นสีดำนะคะ**",
                6621, 5014,
                LocalDateTime.now(), LocalDateTime.now()
        ));

        productRepository.saveAll(entities);
    }

    @Test
    @DisplayName("ค้นหาโดยใช้ Empty String, ได้ผลลัพธ์ทั้งหมด 10 รายการ")
    void findByName_with_emptyString() {
        // Arrange
        initialData();

        // Act
        List<Product> result = productRepository.findByName("");

        // Assert
        assertEquals(10, result.size());
    }

    @Test
    @DisplayName("ค้นหาโดยใช้ช่องว่าง, ได้ผลลัพธ์ทั้งหมด 10 รายการ")
    void findByName_with_whiteSpaceCharacter() {
        // Arrange
        initialData();

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
        initialData();

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
        initialData();

        // Act
        String name = "zippo";
        List<Product> result = productRepository.findByName(name.trim());

        // Assert
        assertEquals(0, result.size());
    }
}