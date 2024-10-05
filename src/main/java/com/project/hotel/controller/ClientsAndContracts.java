package com.project.hotel.controller;

import com.project.hotel.models.AllServices;
import com.project.hotel.models.ClientOfHotel;
import com.project.hotel.models.Contracts;
import com.project.hotel.service.AllServicesService;
import com.project.hotel.service.ClientOfHotelService;
import com.project.hotel.service.ContractsService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel_management/clients_and_contracts")
public class ClientsAndContracts {

    private final ClientOfHotelService clientOfHotelService;
    private final ContractsService contractsService;
    @Autowired
    public ClientsAndContracts(ClientOfHotelService clientOfHotelService, ContractsService contractsService) {
        this.clientOfHotelService = clientOfHotelService;
        this.contractsService = contractsService;
    }



    @GetMapping()
    public String clientsAndContracts(){
        return "Clients and contracts/сlients_and_contracts";
    }

    @GetMapping("/clients_of_hotel")
    public String findClientsAll(Model model){
        List<ClientOfHotel> clientOfHotelList = clientOfHotelService.findAll();
       // System.out.println(clientOfHotelList.get(0));
        model.addAttribute("clientOfHotelList",clientOfHotelList);
        return "Clients and contracts/сlients/client_of_hotel_list";
    }

    @GetMapping("/client_of_hotel_create")
    public String createServiceForm(@ModelAttribute("clientOfHotel") ClientOfHotel clientOfHotel){
        return "Clients and contracts/сlients/client_of_hotel_create";
    }
    /// @PostMapping("/add_clients")
    @PostMapping()
    public String create(@ModelAttribute("clientOfHotel")  ClientOfHotel clientOfHotel
    ) {
        System.out.println("Hello world!");
        clientOfHotelService.save(clientOfHotel);
        return "redirect:/hotel_management/clients_and_contracts";
    }

    //--------------------------------------------------------

    @GetMapping("create_contracts")
    public String createContractsForm(Model model, @ModelAttribute("clientOfHotel") ClientOfHotel clientOfHotel,@ModelAttribute("contracts") Contracts contracts) {

        List<ClientOfHotel> clientOfHotelList = clientOfHotelService.findAll();
        //System.out.println(clientOfHotelList.get(0));
        model.addAttribute("clientOfHotelList",clientOfHotelList);


        return "Clients and contracts/contracts/create_contracts";
    }

    @PatchMapping("/add") // @PatchMapping("/add") OR @PostMapping("/add")
    public String createContracts(@ModelAttribute("clientOfHotel") ClientOfHotel clientOfHotel,@ModelAttribute("contracts") Contracts contracts) {
        //System.out.println(clientOfHotel.getClientId());
        // System.out.println("----------------------------");
        //System.out.println(contracts.getTermOfStay());
        contracts.setClientOfHotel(clientOfHotel);
        contractsService.save(contracts);
        return "redirect:/hotel_management/clients_and_contracts";
    }
    //------------------------------



}



