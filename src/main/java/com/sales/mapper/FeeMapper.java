package com.sales.mapper;

import com.sales.domain.Fee;
import com.sales.response.FeeGetResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeeMapper {
    FeeGetResponse toFeeGetResponse(Fee fee);

    List<FeeGetResponse> toFeeGetResponseList(List<Fee> fees);
}
