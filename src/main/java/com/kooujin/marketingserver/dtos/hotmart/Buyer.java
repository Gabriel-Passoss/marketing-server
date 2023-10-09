package com.kooujin.marketingserver.dtos.hotmart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Buyer {
    @NonNull
    private String email;

    @NonNull
    private String name;

    public Buyer() {}
}
