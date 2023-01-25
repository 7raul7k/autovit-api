package ro.mycode.autovitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.model.Masina;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MasinaRepo  extends JpaRepository<Masina, Long> {


    @Query("Select car from Masina car where car.owner = ?1")
    Optional<Masina> findByOwner(String owner);

    @Query("Select car.make from Masina car where car.make = ?1 ")
    List<Masina> showCarsByMake(String make);

    @Modifying
    @Query("Update Masina car set car.brand = ?1 where car.owner = ?2 ")
    void updateBrand(String newBrand,String owner);

    @Query("SELECT car.brand FROM Masina car ")
    List<String> showAllCarsbyBrand();

    @Query("SELECT car.color FROM Masina car")
    List<String> showAllCarsbyColor();

    @Query("SELECT car.year FROM Masina car ")
   List<String> showAllCarsByYear();



}
