package com.chris.codeclause_currency_converter.module;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("currency")
@Slf4j
public class ConvertionController {
    private ConvertionService convertionService;

    @Autowired
    public ConvertionController(ConvertionService convertionService) {
        this.convertionService = convertionService;
    }

    @GetMapping("/page")
    public String toPage(@ModelAttribute("convertData") ConvertData convertData, BindingResult result, Model model) throws IOException {
           model.addAttribute("convertData", convertData);

          if(result.hasErrors()){
               convertData.setAmount_to_be_converted(0.0);
           }
           Map<String, String> currencies = convertionService.currencyData();
           model.addAttribute("currencies", currencies);

           double resultdouble = convertionService.convertAmount(convertData);
           model.addAttribute("result", resultdouble);

           String errormsg = "enter amount to be converted";
           model.addAttribute("errormsg", errormsg);


        log.info("conversion request");
        return "conversion_page";
    }

}