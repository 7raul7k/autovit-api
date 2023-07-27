package ro.mycode.autovitapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name="Masina")
@Table(name="masini")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Masina implements Comparable<Masina> {

    @Id
    @SequenceGenerator(name="masina_sequence",
    sequenceName = "masina_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator =  "masina_sequence"
    )
    @Column(name ="id")
    private long id;
    @Column(name ="owner",
    nullable = false,
    columnDefinition = "TEXT")
    private String owner;
    @Column(name = "brand",
    nullable = false,
    columnDefinition = "TEXT")
    private String brand;
    @Column(name = "make",
    nullable = false,
    columnDefinition = "TEXT")
    private String make;
    @Column(name = "color",
    nullable = false,
    columnDefinition = "TEXT")
    private String color;
    @Column(name = "year",
    nullable = false,
    columnDefinition = "INT")
    private int year;



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

