package com.kooujin.marketingserver.dtos.pepper;

import lombok.*;

@Getter
@AllArgsConstructor
public class PepperDTO {
    @NonNull
    private String doc;

    @NonNull
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    private String name;

    public PepperDTO() {}

    public void setDoc(String doc) {
        this.doc = doc.replaceAll("\\.", "").replaceAll("-", "");
    }
}
