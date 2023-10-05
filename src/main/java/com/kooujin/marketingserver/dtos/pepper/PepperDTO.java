package com.kooujin.marketingserver.dtos.pepper;

import lombok.*;

@AllArgsConstructor
public class PepperDTO {
    @NonNull
    private String doc;

    @NonNull
    @Getter
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    private String name;

    public PepperDTO() {}

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc.replaceAll("\\.", "").replaceAll("-", "");
    }
}
