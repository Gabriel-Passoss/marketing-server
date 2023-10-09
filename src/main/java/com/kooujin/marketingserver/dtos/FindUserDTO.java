package com.kooujin.marketingserver.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class FindUserDTO {
    @Nullable
    private String cpf;

    @Nullable
    private String email;

    public FindUserDTO() {}
}
