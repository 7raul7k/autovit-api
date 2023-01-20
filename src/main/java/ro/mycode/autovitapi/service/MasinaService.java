package ro.mycode.autovitapi.service;


import org.springframework.stereotype.Service;
import ro.mycode.autovitapi.exceptions.CarExistException;
import ro.mycode.autovitapi.exceptions.CarNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {

    private MasinaRepo masinaRepo;

    public MasinaService(MasinaRepo masinaRepo) {
        this.masinaRepo = masinaRepo;
    }

    public List<Masina> getallCars(){
        return masinaRepo.findAll();
    }

    @Transactional
    public void addCar(Masina car) throws CarExistException, CarNotFoundException {
        if (this.getCarbyOwner(car.getOwner()) == null){
            masinaRepo.save(car);
        }
        throw new CarExistException();
    }

    @Transactional
   public void removeCar(String owner) throws CarNotFoundException{
        Optional<Masina> car = this.masinaRepo.findByOwner(owner);
        if(car.isEmpty()==false){
            this.masinaRepo.delete(car.get());
        }else{
            throw new CarNotFoundException();
        }
   }

    @Transactional
    public Masina getCarbyOwner(String owner) throws CarNotFoundException {

        Optional<Masina>masina= masinaRepo.findByOwner(owner);

        if(masina.isEmpty()){
            throw  new CarNotFoundException();
        }else{

            return  masina.get();
        }
    }

    public List<String> getAllCarsByBrand() throws CarNotFoundException {
        List<String> masina = this.masinaRepo.showAllCarsbyBrand();

        if(masina.isEmpty()){
            throw new CarNotFoundException();
        }
        return masina;

    }

    @Transactional
    public void updateBrand(String newBrand,String owner) throws CarNotFoundException{
        if(this.masinaRepo.findByOwner(owner) != null){

            this.masinaRepo.updateBrand(newBrand,owner);
        }else{
            throw new CarNotFoundException();
        }
    }

    public List<String> showCarbyBrand() throws CarNotFoundException {

        List<String> masinas = this.masinaRepo.showAllCarsbyBrand();

        if(masinas.isEmpty()){
            throw new CarNotFoundException();
        }
        return masinas;

    }


    public List<String> showCarbyColor() throws CarNotFoundException {
        List<String> masinas = this.masinaRepo.showAllCarsbyColor();

        if(masinas.isEmpty()){
            throw new CarNotFoundException();
        }
        return masinas;
    }

    public List<String> showAllCarByYear() throws CarNotFoundException {
      List<String> masinas = this.masinaRepo.showAllCarsByYear();
        if(masinas.isEmpty()){
            throw new CarNotFoundException();
        }
        return masinas;
    }



}
