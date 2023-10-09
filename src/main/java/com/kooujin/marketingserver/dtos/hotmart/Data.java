package com.kooujin.marketingserver.dtos.hotmart;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@lombok.Data
@AllArgsConstructor
public class Data {
    @NonNull
    private Buyer buyer;

    public Data() {}
}
