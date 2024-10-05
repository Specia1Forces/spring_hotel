package com.project.hotel.controller;

import com.project.hotel.models.*;
import com.project.hotel.service.ClientOfHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.hotel.service.AccountsService;
import com.project.hotel.service.BookingService;

import java.util.List;

@Controller
@RequestMapping("/hotel_management/room_reservations")
public class RoomReservations {
    private final BookingService bookingService;
    private final ClientOfHotelService clientOfHotelService;

    private final AccountsService accountsService;

    @Autowired
    public RoomReservations(BookingService bookingService, ClientOfHotelService clientOfHotelService, AccountsService accountsService) {
        this.bookingService = bookingService;
        this.clientOfHotelService = clientOfHotelService;
        this.accountsService = accountsService;
    }


    @GetMapping("/booking_list")
    public String findAll(Model model){
        List<Booking>  bookingList = bookingService.findAll();
        model.addAttribute("bookingList", bookingList);
        return "room reservations/reservation/booking_list";
    }

    @GetMapping()
    public String roomReservations(){
        return "room reservations/room_reservations";
    }

    @GetMapping("/create_reservations")
    public String createReservationsForm(Model model, @ModelAttribute("clientOfHotel") ClientOfHotel clientOfHotel, @ModelAttribute("booking") Booking booking) {

        List<ClientOfHotel> clientOfHotelList = clientOfHotelService.findAll();
        //System.out.println(clientOfHotelList.get(0));
        model.addAttribute("clientOfHotelList",clientOfHotelList);


        return "room reservations/reservation/reservation";
    }

    @PatchMapping("/add") // @PatchMapping("/add") OR @PostMapping("/add")
    public String createReservations(@ModelAttribute("clientOfHotel") ClientOfHotel clientOfHotel,@ModelAttribute("booking") Booking booking) {
        //System.out.println(clientOfHotel.getClientId());
        // System.out.println("----------------------------");
        //System.out.println(contracts.getTermOfStay());
        booking.setClientOfHotel1(clientOfHotel);
        bookingService.save(booking);
        return "redirect:/hotel_management/room_reservations/booking_list";
    }
    //-------------------------------------------



    @GetMapping("/accounts_list")
    public String findAccountsAll(Model model){
        List<Accounts>  accountsList = accountsService.findAll();
        model.addAttribute("accountsList", accountsList);
        return "room reservations/accounts/accounts_list";
    }

    @GetMapping("create_accounts")
    public String createAccountsForm(Model model, @ModelAttribute("booking") Booking booking,@ModelAttribute("accounts") Accounts accounts) {

        List<Booking> bookinglList = bookingService.findAll();
        //System.out.println(clientOfHotelList.get(0));
        model.addAttribute("bookingList",bookinglList);


        return "room reservations/accounts/create_accounts";
    }

    @PatchMapping("/add_accounts") // @PatchMapping("/add") OR @PostMapping("/add")
    public String createAccounts(@ModelAttribute("booking") Booking booking,@ModelAttribute("accounts") Accounts accounts) {
        //System.out.println(clientOfHotel.getClientId());
        // System.out.println("----------------------------");
        //System.out.println(contracts.getTermOfStay());
        accounts.setBooking(booking);
        accountsService.save(accounts);
        return "redirect:/hotel_management/room_reservations/accounts_list";
    }


}
