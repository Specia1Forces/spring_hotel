package com.project.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DifferentiationOfStaffAndCustomers {
    @GetMapping("/hotel_management")
    public String hotelManagement(){
        return "differentiation of staff and customers/dif_of_staff_and_customers.html";
    }
}
