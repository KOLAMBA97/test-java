package com.example.api.controllers;

import com.example.api.dto.CreateFactDTO;
import com.example.api.entity.Fact;
import com.example.api.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fact")
public class FactController {

    @Autowired
    FactService factService;

    @PostMapping("/add")
    public Fact createFact(@RequestBody CreateFactDTO createFactDTO) {
        return factService.createFact(createFactDTO.getUser_id(), createFactDTO.getCategory(), createFactDTO.getSum(), createFactDTO.getComment());
    }

    @GetMapping("/byDate")
    public List<Fact> getByDates(@RequestParam long user_id,@RequestParam String data1,@RequestParam String data2) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return factService.getFactsBetween(user_id, format.parse(data1), format.parse(data2));
    }

    @GetMapping("/delFact")
    public void delByDates(@RequestParam long user_id,@RequestParam long id)throws ParseException {
        factService.DeleteFactBetween(user_id, id);
    }

}
