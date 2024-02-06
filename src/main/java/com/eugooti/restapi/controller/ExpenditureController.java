package com.eugooti.restapi.controller;


import com.eugooti.restapi.entity.Expenditure;
import com.eugooti.restapi.service.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenditure")

public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @PostMapping("/createExpenditure")
    public Expenditure createExpenditure(@RequestBody Expenditure expenditure){
        return expenditureService.createExpenditure(expenditure);
    }

    @PostMapping("/createExpenditures")
    public List<Expenditure> createExpenditure(@RequestBody List<Expenditure> expenditure){
        return expenditureService.createExpenditures(expenditure);
    }

    @GetMapping("/getExpenditures")
    public List<Expenditure> getExpendituresById(){
        return expenditureService.getExpenditures();
    }

    @GetMapping("/getExpenditureById/{id}")
    public Expenditure getAllExpenditures(@PathVariable int id){
        return expenditureService.getExpendituresById(id);
    }

    @GetMapping("/getAllExpendituresByUser/{user}")
    public List<Expenditure> getAllExpendituresByUser(@PathVariable String user){
        return expenditureService.getExpendituresByUser(user);
    }

    @PutMapping("/updateExpenditure")
    public Expenditure updateExpenditure(Expenditure expenditure){
        return expenditureService.updateExpenditure(expenditure);
    }

    @DeleteMapping("/deleteExpenditure/{id}")
    public String deleteExpenditure(@PathVariable int id){
        return expenditureService.deleteExpenditure(id);
    }


}
