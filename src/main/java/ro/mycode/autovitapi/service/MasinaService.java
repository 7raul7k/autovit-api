package ro.mycode.autovitapi.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.mycode.autovitapi.exceptions.CarExistException;
import ro.mycode.autovitapi.exceptions.CarNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import java.util.List;

@Component
public class MasinaService {

    private MasinaRepo masinaRepo;

    public MasinaService(MasinaRepo masinaRepo) {
        this.masinaRepo = masinaRepo;
    }

    public List<Masina> getallCars(){

        return masinaRepo.findAll();
    }

    public void addCar(Masina car) throws CarExistException {
        if (this.getCarbyOwner(car.getOwner()) != null){
            masinaRepo.save(car);
        }
        throw new CarExistException("This car exist");
    }

    public void removeCar(Masina car) throws CarNotFoundException{
        boolean flag = contains(car);
        if(flag == true){
            masinaRepo.delete(car);
        }
        throw  new CarNotFoundException("Car not found");
    }
    public Masina getCarbyOwner(String owner){
        return masinaRepo.findByOwner(owner);
    }

    public boolean contains(Masina car){
        return masinaRepo.containsCar(car.getOwner(), car.getBrand());

    }

    public void updateBrand(String newBrand,String owner) throws CarNotFoundException{
        Masina car = getCarbyOwner(owner);
        boolean flag = contains(car);

        if(flag == true){
            masinaRepo.updateBrand(newBrand, car.getOwner());
        }else{
            throw new CarNotFoundException("Car not found!");
        }
    }

    public void updateColor(String newColor,String owner) throws CarNotFoundException{
        Masina car = getCarbyOwner(owner);
        boolean flag = contains(car);
        if(flag == true){
            masinaRepo.updateColor(newColor,car.getOwner());
        }else{
            throw new CarNotFoundException("Car not found!");
        }
    }
    public void updateMake(String newMake,String owner) throws CarNotFoundException{
        Masina car = getCarbyOwner(owner);
        boolean flag = contains(car);
        if(flag == true){
            this.masinaRepo.updateMake(newMake, owner);
        }else{
            throw new CarNotFoundException("Car not exist!");
        }
    }

    public void updateYear(int year,String owner) throws CarNotFoundException{
        Masina car = getCarbyOwner(owner);
        boolean flag = contains(car);
        if(flag == true){
            this.masinaRepo.updateYear(year,owner);
        }else{
            throw new CarNotFoundException("Car not exist!");
        }
    }

}
