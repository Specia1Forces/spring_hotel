package com.project.hotel.controller;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.Maids;
import com.project.hotel.models.TechnicalMaintenancePersonnel;
import com.project.hotel.service.MaidsService;
import com.project.hotel.service.TechnicalMaintenancePersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotel_management/personnel")
public class Personnel {
    private final MaidsService maidsService;
    private final TechnicalMaintenancePersonnelService technicalMaintenancePersonnelService;
    @Autowired
    public Personnel(MaidsService maidsService, TechnicalMaintenancePersonnelService technicalMaintenancePersonnelService) {
        this.maidsService = maidsService;
        this.technicalMaintenancePersonnelService = technicalMaintenancePersonnelService;
    }



    @GetMapping()
    public String selectPersonnel(){
        return "select_personnel";
    }

    @GetMapping("/maids")
    public String maidsFindAll(Model model){
        List<Maids> maidsList = maidsService.findAll();
        model.addAttribute("maidsList", maidsList);
        return "personnel/maids/maids_list";
    }

    @GetMapping("/maids/maid_create")
    public String maidsCreateServiceForm(@ModelAttribute("maids") Maids maids){
        System.out.println("Hello world!2");
        return "personnel/maids/maid_create";
    }

    @PostMapping("/maids")
    public String maidsCreate(@ModelAttribute("maids")  Maids maids
    ) {
        System.out.println("Hello world!");
        maidsService.save(maids);
        return "redirect:/hotel_management/personnel/maids";
    }

    //технические

    @GetMapping("/collaborator_maintenance")
    public String collaboratorMaintenancefindAll(Model model){
        List<TechnicalMaintenancePersonnel> technicalMaintenancePersonnelList = technicalMaintenancePersonnelService.findAll();
        System.out.println(technicalMaintenancePersonnelList.get(0).getName());
        System.out.println(technicalMaintenancePersonnelList.get(0).getLastName());
        System.out.println(technicalMaintenancePersonnelList.get(0).getMiddleName());

        model.addAttribute("technicalMaintenancePersonnelList", technicalMaintenancePersonnelList);
        return "personnel/collaborator_mainenance/collaborator_maintenance_list";
    }


    @GetMapping("/collaborator_maintenance/collaborator_maintenance_create")
    public String collaboratorMaintenanceCreateServiceForm(@ModelAttribute("technicalMaintenancePersonnel") TechnicalMaintenancePersonnel technicalMaintenancePersonnel){

        return "personnel/collaborator_mainenance/collaborator_maintenance_create";
    }

    @PostMapping("/collaborator_maintenance")
    public String collaboratorMaintenanceCreate(@ModelAttribute("technicalMaintenancePersonnel") TechnicalMaintenancePersonnel technicalMaintenancePersonnel
    ) {
        technicalMaintenancePersonnelService.save(technicalMaintenancePersonnel);
        return "redirect:/hotel_management/personnel/collaborator_mainenance";
    }





}

