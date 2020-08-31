package com.protosstechnology.train.bootexamine.document;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {
    @NonNull private Integer id;
    @NonNull private String documentNumber;
    @NonNull private String description;
}
