package ro.mycode.autovitapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name="Masina")
@Table(name="masini")
@NoArgsConstructor
@AllArgsConstructor
public class Masina implements Comparable<Masina> {


   @GeneratedValue(
           strategy = GenerationType.AUTO
   )
    @Id
    private Long id;
    private String owner;
    private String brand;
    private int year;
    private String motorType;

    public Masina(String owner, String brand, int year, String motorType) {
        this.owner = owner;
        this.brand = brand;
        this.year = year;
        this.motorType = motorType;
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
        return owner+","+brand+","+year+","+motorType;
    }

    @Override
    public boolean equals(Object obj){
        Masina m = (Masina) obj;
        if(this.owner.equals(m.owner)&&this.brand.equals(m.brand)&&this.year==m.year&&this.motorType.equals(m.motorType)){
            return true;
        }
        return false;
    }
}

