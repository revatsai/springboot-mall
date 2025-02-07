package com.revatsai.springbootmall.controller;

import com.revatsai.springbootmall.constant.ProductCategory;
import com.revatsai.springbootmall.dto.ProductQueryParams;
import com.revatsai.springbootmall.dto.ProductRequest;
import com.revatsai.springbootmall.model.Product;
import com.revatsai.springbootmall.service.ProductService;
import com.revatsai.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController // 表controller的bean
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products") // 篩選特定商品分類
    // 表示從url路徑中取得的參數
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序, default從最新到最舊
            @RequestParam(defaultValue = "created_date") String orderBy, // 根據什麼欄位去排序
            @RequestParam(defaultValue = "desc") String sort, // 使用升序或是降序去排序

            // 分頁
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit, // 要取得幾筆數據
            @RequestParam(defaultValue = "0") @Min(0) Integer offset // 要跳過多少筆數據
            ) {
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // 取得product list
        List<Product> productList = productService.getProducts(productQueryParams);

        // 取得product總數
        Integer total = productService.countProduct(productQueryParams);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {

        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId); // 從資料庫取得商品的數據出來
        return ResponseEntity.status(HttpStatus.CREATED).body(product); // 把創建的商品數據放在body回傳給前端
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {
        //  檢查product是存在
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 表示數據已經被刪掉了
    }
}
