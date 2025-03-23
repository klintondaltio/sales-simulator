package com.sales.controller;

import com.sales.mapper.FeeMapper;
import com.sales.request.FeePostRequest;
import com.sales.request.FeePutRequest;
import com.sales.response.FeeGetResponse;
import com.sales.response.FeePostResponse;
import com.sales.service.FeeService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.info("Request all fees List");
        var fees = feeService.findAll();
        var feeGetResponses = feeMapper.toFeeGetResponseList(fees);
        return ResponseEntity.ok(feeGetResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeGetResponse> findById(@PathVariable Long id){
        log.info("Request fees by the id: '{}'", id);
        var fee = feeService.findbyId(id);
        var response = feeMapper.toFeeGetResponse(fee);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<FeePostResponse> save(@RequestBody @Valid FeePostRequest request) {
        log.info("Request received a saved fee, param name: '{}'", request.getFeePercent());
        var fee = feeMapper.toFee(request);
        feeService.save(fee);
        var response = feeMapper.toFeePostResponse(fee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Delete fee by id, param name: '{}'", id);
        feeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateById(@RequestBody @Valid FeePutRequest request) {
        log.info("Update user, param name: '{}'", request.toString());
        var feeToUpdated = feeMapper.toFee(request);
        feeService.update(feeToUpdated);
        return ResponseEntity.noContent().build();
    }
}
