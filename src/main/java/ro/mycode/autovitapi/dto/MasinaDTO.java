package ro.mycode.autovitapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MasinaDTO {

    private String owner;
    private String brand;
    private String make;
    private String color;
    private int year;
}
