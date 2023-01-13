package ro.mycode.autovitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.model.Masina;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasinaRepo  extends JpaRepository<Masina, Long> {


    @Query("Select car from Masina car where car.owner = ?1")
    Masina findByOwner(String owner);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Car c where c.owner in ?1 AND c.brand in ?2")
    boolean containsCar(String owner,String brand);

    @Modifying
    @Query("UPDATE Masina c SET c.color = ?1 WHERE c.owner = ?2")
    void updateColor(String newColor,String owner);

    @Modifying
    @Query("UPDATE Masina c SET c.brand = ?1 WHERE c.owner = ?2 ")
    void updateBrand(String newBrand,String owner);

    @Modifying
    @Query("UPDATE Masina c SET c.year = ?1 WHERE c.owner = ?2")
    void updateYear(int newYear,String owner);

    @Modifying
    @Query("UPDATE Masina c SET c.make = ?1 WHERE c.owner = ?2")
    void updateMake(String newMake,String owner);

}
