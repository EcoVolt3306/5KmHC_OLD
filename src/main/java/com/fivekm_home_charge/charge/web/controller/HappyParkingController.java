package com.fivekm_home_charge.charge.web.controller;

import com.fivekm_home_charge.charge.service.HappyParkingService;
import com.fivekm_home_charge.charge.web.dto.HappyParkingDto;
import com.fivekm_home_charge.charge.web.dto.HappyParkingRequestListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HappyParkingController {
    @Autowired
    HappyParkingService happyParkingService;

    @GetMapping("/happyParking")
    public String happyParking() {
        return "/happyParking/happyParking";
    }

    @GetMapping("/happyParking/happyParkingRegister")
    public String happyParkingRegister(HttpServletRequest request, HttpServletResponse response,
                                       Model model){
        HttpSession session = request.getSession();
        System.out.println("주차장등록현재세션아이디 : " +  session.getAttribute("userId"));
        model.addAttribute("user", session.getAttribute("userId"));
        return "/happyParking/happyParkingRegister";
    }

    @GetMapping("/happyParking/happyParkingSearch")
    public String happyParkingSearch(Model model) throws Exception{
        model.addAttribute("book1", happyParkingService.happyParkingBook1());
        return "/happyParking/happyParkingSearch";
    }

    @GetMapping("/happyParking/happyParkingHistory")
    public String happyParkingHistory(){
        return "/happyParking/happyParkingHistory";
    }

    @GetMapping("/admin/happyParkingRequestList")
    public String happyParkingRequestList(Model model) throws Exception{
        model.addAttribute("requestList", happyParkingService.happyParkingRequestList());
        return "/admin/happyParkingRequestList";
    }

    @GetMapping("/happyParking/requestHappyParking/{parkingName}")
    public String requestHappyParking(@PathVariable String parkingName, Model model) throws Exception{
        model.addAttribute("request", happyParkingService.requestHappyParking(parkingName));
        return "/admin/happyParkingRequest";
    }

}
