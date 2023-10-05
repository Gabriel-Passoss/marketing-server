package com.kooujin.marketingserver.dtos;

import lombok.*;

@Getter
@AllArgsConstructor
public class SaveAdminDTO {
    @NonNull
    private String cpf;

    @NonNull
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    private String name;

    public SaveAdminDTO() {}

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("\\.", "").replaceAll("-", "");
    }
}
