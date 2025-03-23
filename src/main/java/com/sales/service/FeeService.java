package com.sales.service;

import com.sales.domain.Fee;
import com.sales.exception.NotFoundException;
import com.sales.repository.FeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public List<Fee> findAll(){
        return feeRepository.findAll();
    }
    public Fee findbyId(Long id){
        return feeRepository.findById(id).orElseThrow(()->new NotFoundException("Fee not found"));
    }

    public void save(Fee fee){
        assertFeeExists(fee);
        feeRepository.save(fee);
    }

    public void delete(Long id){
        var fee = feeRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Fee not found."));
        feeRepository.delete(fee);
    }

    public void update(Fee fee){
        assertFeeExists(fee);
        feeRepository.save(fee);
    }

    private void assertFeeExists(Fee fee) {
        if(fee.getId() != null)
            findbyId(fee.getId());
    }
}
