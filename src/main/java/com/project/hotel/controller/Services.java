package com.project.hotel.controller;

import com.project.hotel.models.AllServices;
import com.project.hotel.service.AllServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Services {
    private final AllServicesService allServicesService;

    @Autowired
    public Services(AllServicesService allServicesService) {
        this.allServicesService = allServicesService;
    }

    @GetMapping("/all_services")
    public String findAll(Model model){
        List<AllServices> allServicesList = allServicesService.findAll();
        model.addAttribute("allServicesList", allServicesList);
        return "all_services_list";
    }

    @GetMapping("/service_create")
    public String createServiceForm(@ModelAttribute("allServices") AllServices allServices){
        return "service_create";
    }

    @PostMapping("/all_services")
    public String create(@ModelAttribute("allServices")  AllServices allServices
                        ) {

        allServicesService.save(allServices);
        return "redirect:/all_services";
    }

    @GetMapping("/service_delete/{id}")
    public String deleteService(@PathVariable("id") int id){
        allServicesService.delete(id);
        return "redirect:/all_services";
    }

    @GetMapping("/service_edit/{id}")
    public String editService(Model model, @PathVariable("id") int id) {
        model.addAttribute("allServices", allServicesService.findOne(id));
        return "service_edit";
    }

    @PatchMapping("/all_services/{id}")
    public String updateServiceForm(@ModelAttribute("allServices") AllServices allServices,
                         @PathVariable("id") int id) {


        allServicesService.update(id, allServices);
        return "redirect:/all_services";
    }






    /*
    @DeleteMapping("service_delete/{id}")
    public String delete(@PathVariable("id") int id) {
        allServicesService.delete(id);
        System.out.println("мы тут");

        return "redirect:/all_services";
    }
         */

    /*
    @PostMapping("/user-create")
    public String createUser(AllServicesS allServicesService1){
        allServicesService.saveService(allServicesService1)
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    /*
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

     */
}
