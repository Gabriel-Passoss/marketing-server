package com.kooujin.marketingserver.dtos.perfect_pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Customer {
    @NonNull
    private String full_name;

    @NonNull
    private String email;

    @NonNull
    private String identification_number;
}
