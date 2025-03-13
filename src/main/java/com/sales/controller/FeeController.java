package com.sales.controller;

import com.sales.mapper.FeeMapper;
import com.sales.response.FeeGetResponse;
import com.sales.service.FeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"v1/fee","v1/fee/"})
@Log4j2
public class FeeController {

    public final FeeService feeService;
    public final FeeMapper feeMapper;

    public FeeController(FeeService feeService, FeeMapper feeMapper) {
        this.feeService = feeService;
        this.feeMapper = feeMapper;
    }

    @GetMapping()
    public ResponseEntity<List<FeeGetResponse>> feeFindAll(){
        //log.info("Request all fees List");
        var fees = feeService.findAll();
        var feeGetResponses = feeMapper.toFeeGetResponseList(fees);
        return ResponseEntity.ok(feeGetResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeGetResponse> findById(@PathVariable Long id){
        //log.info("Request fees by the id: '{}'", id);
        var fee = feeService.findbyId(id);
        var response = feeMapper.toFeeGetResponse(fee);
        return ResponseEntity.ok(response);
    }
}
