package com.eugooti.restapi.service;

import com.eugooti.restapi.entity.Expenditure;
import com.eugooti.restapi.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureService {
    @Autowired
    private ExpenditureRepository expenditureRepository;

    public Expenditure createExpenditure(Expenditure expenditure){
        return expenditureRepository.save(expenditure);
    }
    public List<Expenditure> createExpenditures(List<Expenditure>  expenditure){
        return expenditureRepository.saveAll(expenditure);
    }
    public List<Expenditure>  getExpenditures(){
        return expenditureRepository.findAll();
    }
    public Expenditure getExpendituresById(int id){
        return expenditureRepository.findById(id).orElse(null);
    }
    public List<Expenditure> getExpendituresByUser(String user){
        return expenditureRepository.findByCreatedBy(user);
    }
    public Expenditure updateExpenditure(Expenditure expenditure){

        Expenditure expenditure1=expenditureRepository.findById(expenditure.getId()).orElse(null);
        assert expenditure1!=null;

        expenditure1.setName(expenditure.getName());
        expenditure1.setDescription(expenditure.getDescription());
        expenditure1.setCategory(expenditure.getCategory());
        expenditure1.setCost(expenditure.getCost());

        return expenditureRepository.save(expenditure1);
    }
    public String deleteExpenditure(int id){
         expenditureRepository.deleteById(id);

         return "Expenditure deleted successfully";
    }


}
