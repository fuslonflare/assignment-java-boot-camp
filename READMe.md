## ขอบเขตการทำงาน ##
เนื่องจากพัฒนาได้เสร็จเพียง 3 Feature คือ
- การค้นหาสินค้า (1. Search product by name)
- การดึงข้อมูลสินค้า (3. Show product detail)
- การเพิ่มสินค้าลงตะกร้า (4. Add product to basket)

## Flow การทำงาน ##
API ที่พัฒนามี 3 API ซึ่ง Flow การทำงานก็จะเรียงตั้งแต่
- เมื่อ user ทำการกรอก keyword เพื่อจะทำการค้นหาสินค้า, front-end จะส่ง keyword มาที่ api `/product/search`
- backed-end จะ response ด้วย list ของสินค้าที่ตรงกับ keyword ที่ user กรอกเข้ามา
- เมื่อ user คลิกเลือกสินค้าที่ต้องการดูรายละเอียด, FE จะเรียก API `/product/{id}` เพื่อ response รายละเอียดของสินค้านั้น ๆ ให้ FE
- เมื่อ user คลิกปุ่ม เพิ่มลงตะกร้า, FE จะเรียก API `/userBasket/addProductToBasket` โดยส่ง `userId`, `productId` และ `amount` มาด้วย เพื่อทำการ Insert Record ลง Table

## APIs ##
| HttpMehod | URL                            | Descrition                        | Sample Request Body & Response Body                                                |
|-----------|--------------------------------|-----------------------------------|------------------------------------------------------------------------------------|
| POST      | /product/search                | ใช้สำหรับการค้นหาสินค้าตามชื่อสินค้า       | <a href="https://github.com/fuslonflare/assignment-java-boot-camp/issues/3#issue-1142323078" target="_blank">#3</a> |
| GET       | /product/{id}                  | ใช้สำหรับดึงรายละเอียดข้อมูลของสินค้า     | <a href="https://github.com/fuslonflare/assignment-java-boot-camp/issues/4#issue-1144969872" target="_blank">#4</a> |
| POST      | /userBasket/addProductToBasket | ใช้สำหรับการเพิ่มสินค้าลงตะกร้าของผู้ใช้งาน | <a href="https://github.com/fuslonflare/assignment-java-boot-camp/issues/5#issue-1149055358" target="_blank">#5</a> |

## Initial Data ##
ระบบทำการ Initial Data ข้อมูลของ Product ให้จำนวน 10 รายการ <a href="https://gist.github.com/fuslonflare/813006c6964f742b6a655f8ab1b5e7a0.js" target="_blank">ดังนี้</a>

สำหรับ UserId สามารถใส่ได้ตามต้องการ เนื่องจากใน API `/userBasket/addProductToBasket` ยังไม่มีการตรวจสอบว่า `userId` จาก Request Body ถูกต้องหรือไม่ เพราะจริง ๆ แล้ว หากไม่ถูกต้อง แสดงว่า FE ส่งมาผิด

## Tables ##
**`Product`** : เก็บรายการสินค้าทั้งหมดในระบบ

**`User`** : เก็บรายการผู้ใช้งานทั้งหมดในระบบ

**`UserAddress`** : เก็บที่อยู่ของผู้ใช้งานทั้งหมดในระบบ

**`UserBasket`** : เก็บรายการสินค้าและจำนวนในตะกร้าของผู้ใช้งาน
