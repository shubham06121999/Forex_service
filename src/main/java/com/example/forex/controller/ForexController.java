package com.example.forex.controller;


import com.example.forex.model.Forex;
import com.example.forex.service.ForexService;
import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/v1")
public class ForexController {

    public final ForexService  forexService;


    public ForexController(ForexService forexService) {
        this.forexService = forexService;
    }

    @GetMapping(path = "/{Apikey}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public JsonNode getvalue(
            @PathVariable(name = "Apikey",required = true) String Apikey ) throws IOException {
        return forexService.GetConvertionRates(Apikey);
    }



}
