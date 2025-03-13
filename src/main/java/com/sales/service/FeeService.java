package com.sales.service;

import com.sales.domain.Fee;
import com.sales.exception.NotFoundException;
import com.sales.repository.FeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Fee save(Fee fee){
        assertFeeExists(fee);
        return feeRepository.save(fee);
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
        findbyId(fee.getId());
    }
}
