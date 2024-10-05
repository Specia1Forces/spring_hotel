package com.project.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel_management/cleaning_and_technical_inspection_log")
public class CleaningAndTechnicalInspectionLog {
    @GetMapping()
    public String cleaningAndTechnicalInspectionLog(){
        return "Cleaning and technical inspection log/cleaning_and_technical_inspection_log.html";
    }
}
