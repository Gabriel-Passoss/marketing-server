package com.kooujin.marketingserver.dtos.hotmart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class HotmartDTO {
    @NonNull
    private String event;

    @NonNull
    private com.kooujin.marketingserver.dtos.hotmart.Data data;
}
