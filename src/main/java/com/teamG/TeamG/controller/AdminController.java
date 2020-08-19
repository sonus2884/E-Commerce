package com.teamG.TeamG.controller;

import com.teamG.TeamG.dto.AdminDto;
import com.teamG.TeamG.dto.AdminResponseDto;
import com.teamG.TeamG.dto.ProductResponse;
import com.teamG.TeamG.dto.ResponseDto;
import com.teamG.TeamG.model.Admin;
import com.teamG.TeamG.model.Products;
import com.teamG.TeamG.model.User;
import com.teamG.TeamG.service.AdminService;
import com.teamG.TeamG.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    private AdminService adminService;
    @Autowired
    private UserService userService;

    @Autowired
    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //------------------ADMIN REGISTRATION --------------------------------------------//


    @PostMapping("/register")
    public ResponseDto<AdminResponseDto> registerAdmin(@RequestBody AdminDto adminDto) {

        Admin admin = adminService.registerAdmin(adminDto);

        return new ResponseDto<>(
                HttpStatus.OK,
                new AdminResponseDto(admin.getId(), admin.getFullName(), admin.getPassword(), admin.getEmail(), admin.getRole()));

    }


    //----------------------FETCHING ALL PRODUCT --------------------------------------------------//


    @GetMapping("/admin/Products")
    public List<ProductResponse> findAdminByEmail() {

        Iterable<Products> ack = adminService.findAdminByEmail();

        List<ProductResponse> prList = new ArrayList<>();

        for (Products products : ack) {

            ProductResponse pr = new ProductResponse();

            pr.setCake_id(products.getCake_id());
            pr.setCake_name(products.getCake_name());
            pr.setSize(products.getSize());
            pr.setMaterial(products.getMaterial());
            pr.setPrice(products.getPrice());
            pr.setDiscount(products.getDiscount());
            pr.setAvailability(products.getAvailability());
            pr.setAdmin_id(products.getAdmin_id());

            prList.add(pr);
        }
        return prList;

    }


    //-----------------------SEARCHING PRODUCT BY ID ------------------------------------------------//


    @GetMapping("/admin/product/{id}")
    public ResponseDto<ProductResponse> findAdminByEmailProductById(
            @PathVariable int id) {

        Products ack = adminService.findAdminByEmailProductById(id);

        return new ResponseDto<>(HttpStatus.OK,
                new ProductResponse(ack.getCake_id(), ack.getCake_name(), ack.getSize(), ack.getMaterial(),
                        ack.getPrice(), ack.getDiscount(), ack.getAvailability(), ack.getAdmin_id()));

    }


    //---------------------DELETING PRODUCT BY ID -----------------------------------------------------//


    @DeleteMapping("/admin/product/delete/{id}")
    public String findAdminByEmailDelProductById(
            @PathVariable int id) {

        String ack = adminService.findAdminByEmailDeleteProductById(id);

        return ack + " Deleted successfully";

    }


    //-------------------------UPDATE PRODUCT BY ID ---------------------------------------------------//


    @PutMapping("/admin/product/update/{id}")
    public ResponseDto<ProductResponse> findAdminByEmailUpdateProductById(
            @PathVariable int id, @RequestBody Products products) {

        Products ack = adminService.findAdminByEmailUpdate(id, products);

        return new ResponseDto<ProductResponse>(HttpStatus.OK,
                new ProductResponse(ack.getCake_id(), ack.getCake_name(), ack.getSize(), ack.getMaterial(),
                        ack.getPrice(), ack.getDiscount(), ack.getAvailability(), ack.getAdmin_id()));

    }


    //------------------------ADDING PRODUCT ---------------------------------------------------------//


    @PostMapping("/admin/addProduct")
    public Products findAdminByEmailAddProduct(
            //@RequestParam("cake_id") int cakeId,
            @RequestParam("cake_name") String cakeName,
            @RequestParam("size") String size, @RequestParam("material") String material,
            @RequestParam("price") int price, @RequestParam("discount") int disc,
            @RequestParam("availability") int availability, @RequestParam("file") MultipartFile file,
            @RequestParam("admin_id") int adminId) throws IOException {

        Products products = new Products(cakeName, size, material, price, disc, availability, file.getBytes(), adminId);

        return adminService.findAdminAndAddProduct(products);


    }


    // ---------------------GENERATING WEEKLY REPORT ---------------------------------------//


    @GetMapping("/admin/Report")
    public List<User> getWeeklyUsers(@RequestParam(name = "Start_date") Date Start_date,

                   @RequestParam(name = "End_date") Date End_date) {

        return userService.getAllUsersByReport(Start_date, End_date);
    }

    //----------------------GENERATING MONTHLY REPORT ---------------------------------------//



    @GetMapping("/admin/MonthlyReport")
    public List<User> getMonthlyUsers(@RequestParam(name = "Month") String Month,@RequestParam(name = "Year") String Year) throws ParseException
    { String
            Start_date1=Year+"-"+Month+"-01";
        String End_date1=Year+"-"+Month+"-31";
        Date Start_date=Date.valueOf(Start_date1);
        Date End_date=Date.valueOf(End_date1);


        return userService.getAllUsersByReportMonthly(Start_date, End_date);
    }


    // ---------------------FIND PRODUCT BY PAGINATION ---------------------------------------//
    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/{pageNo}/{pageSize}/allproducts")
    public List<ProductResponse> getPaginatedCountries(@PathVariable int pageNo, @PathVariable int pageSize) {

        Iterable<Products> ack = adminService.findPaginated(pageNo, pageSize);

        List<ProductResponse> prList = new ArrayList<>();

        for (Products products : ack) {

            ProductResponse pr = new ProductResponse();

            pr.setCake_id(products.getCake_id());
            pr.setCake_name(products.getCake_name());
            pr.setSize(products.getSize());
            pr.setMaterial(products.getMaterial());
            pr.setPrice(products.getPrice());
            pr.setDiscount(products.getDiscount());
            pr.setAvailability(products.getAvailability());
            pr.setAdmin_id(products.getAdmin_id());

            prList.add(pr);
        }
        return prList;

    }


}
