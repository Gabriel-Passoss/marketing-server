package com.kooujin.marketingserver.dtos.perfect_pay;


import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class PerfectPayDTO {
    @NonNull
    private Customer customer;
}

