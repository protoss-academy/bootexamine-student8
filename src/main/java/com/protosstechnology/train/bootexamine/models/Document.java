package com.protosstechnology.train.bootexamine.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Document {
    private @Id
    @GeneratedValue
    Integer id;

    @NonNull private String documentNumber;
    @NonNull private String description;
}
