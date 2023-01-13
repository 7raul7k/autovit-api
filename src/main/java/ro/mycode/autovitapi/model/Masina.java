package ro.mycode.autovitapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity(name="Masina")
@Table(name="masini")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Masina implements Comparable<Masina> {


   @GeneratedValue(
           strategy = GenerationType.AUTO
   )
    @Id
    private Long id;
    private String owner;
    private String brand;
    private int year;

    private String color;

    private String make;

    public Masina(String owner, String brand, int year, String color, String make) {
        this.owner = owner;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.make = make;
    }



    @Override
    public int compareTo(Masina o) {
    if(o.year > this.year){
        return 1;
    }else if (o.year < this.year ){
        return -1;
    }
    return 0;
    }

    @Override
    public String toString(){
        return owner+","+brand+","+year+","+color+","+make;
    }

    @Override
    public boolean equals(Object obj){
        Masina m = (Masina) obj;
        if(this.owner.equals(m.owner)&&this.brand.equals(m.brand)&&this.year==m.year&&this.color.equals(m.color)&&this.make.equals(m.make)){
            return true;
        }
        return false;
    }

}

