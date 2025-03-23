package com.sales.mapper;

import com.sales.domain.Fee;
import com.sales.request.FeePostRequest;
import com.sales.request.FeePutRequest;
import com.sales.response.FeeGetResponse;
import com.sales.response.FeePostResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeeMapper {

    Fee toFee(FeePostRequest feePostResponse);

    FeePostResponse toFeePostResponse(Fee fee);
    FeeGetResponse toFeeGetResponse(Fee fee);

    List<FeeGetResponse> toFeeGetResponseList(List<Fee> fees);
    Fee toFee(FeePutRequest feePutRequest);
}
