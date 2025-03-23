package com.sales.service;

import com.sales.domain.Fee;
import com.sales.domain.OrderRecord;
import com.sales.exception.NotFoundException;
import com.sales.repository.FeeRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    private final Random random = new Random();

    private final KafkaTemplate<String, OrderRecord> kafkaTemplate;

    public FeeService(FeeRepository feeRepository, KafkaTemplate<String, OrderRecord> kafkaTemplate) {
        this.feeRepository = feeRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<Fee> findAll(){
        return feeRepository.findAll();
    }
    public Fee findbyId(Long id){
        return feeRepository.findById(id).orElseThrow(()->new NotFoundException("Fee not found"));
    }

    @SuppressWarnings("null")
    public void save(Fee fee){
        int partition = random.nextInt(2);
        assertFeeExists(fee);
        feeRepository.save(fee);
        kafkaTemplate.send("fees-processeds", partition, null, new OrderRecord(fee.getId(), fee.getFeeCategory(), fee.getCardSchemaDescription(), fee.getFeePercent()));
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
