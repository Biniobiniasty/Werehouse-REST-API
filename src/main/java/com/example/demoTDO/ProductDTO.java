package com.example.demoTDO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonView({ProductDTOView.Normal.class})
    private long id;
    @JsonView({ProductDTOView.Normal.class, ProductDTOView.Users.class})
    private String name;
    @JsonView({ProductDTOView.Normal.class, ProductDTOView.Users.class})
    private int amount;
    @JsonView({ProductDTOView.Normal.class})
    private LocalDate creationDate;
    @JsonView({ProductDTOView.Normal.class})
    private LocalDate lastDate;

}
