package ro.mycode.autovitapi.view;


import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.stereotype.Component;
import ro.mycode.autovitapi.exceptions.CarExistException;
import ro.mycode.autovitapi.exceptions.CarNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.service.MasinaService;

import java.util.List;
import java.util.Scanner;

@Component
public class ViewMasina {


    private MasinaService masinaService;

    private Scanner scanner;

    public ViewMasina(MasinaService masinaService) {
        this.masinaService = masinaService;
        scanner = new Scanner(System.in);
    }


    public void show(){
        System.out.println("Press 1 to show all cars");
        System.out.println("Press 2 to add car");
        System.out.println("Press 3 to remove a car");
        System.out.println("Press 4 to update car brand");
        System.out.println("Press 5 to update car year");
        System.out.println("Press 6 to update car color");

    }

    public void play() throws CarExistException, CarNotFoundException {

        boolean running = true;

        while (running){

            this.show();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1: afisare();
                break;
                case 2: add();
                break;
                case 3: removeCar();
                break;
                case 4: updateBrand();
                break;
                case 5: updateYear();
                break;
                case 6: updateColor();
                break;
                default:
            }

        }
    }


    public void afisare(){

        List<Masina> masinas = masinaService.getallCars();

        for(Masina m : masinas){


            System.out.println(m);

        }
    }
    public void add () throws CarExistException {
        System.out.println("Insert owner full name:");
        String owner = scanner.nextLine();
        System.out.println("Insert car brand: ");
        String brand = scanner.nextLine();
        System.out.println("Insert car year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Insert car color:");
        String color = scanner.nextLine();
        System.out.println("Insert car make:");
        String make = scanner.nextLine();
        Masina car =  Masina.builder().owner(owner)
                .brand(brand)
                .year(year)
                .color(color)
                .make(make)
                .build();
        this.masinaService.addCar(car);
    }

    public void removeCar() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        Masina car = this.masinaService.getCarbyOwner(owner);
        if(car != null){
            this.masinaService.removeCar(car);
        }else {
            System.out.println("Car with this owner not found");
        }
    }
    public void updateBrand() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        Masina car = this.masinaService.getCarbyOwner(owner);
        if(car != null){
            System.out.println("Input new brand");
            String brand = scanner.nextLine();
            this.masinaService.updateBrand(brand, car.getOwner());
        }else{
            System.out.println("Car with this owner not found");
        }
    }

    public void updateYear() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        Masina car = this.masinaService.getCarbyOwner(owner);
        if(car != null){
            System.out.println("Input new color ");
            String color = scanner.nextLine();
            this.masinaService.updateColor(color, car.getOwner());
        }
    }
    public void updateColor() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        Masina car = this.masinaService.getCarbyOwner(owner);
        if(car != null){
            System.out.println("Input new year");
            int year = Integer.parseInt(scanner.nextLine());
            this.masinaService.updateYear(year,car.getOwner());
        }else{
            System.out.println("Car not found");
        }
    }

    public void updateMake() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        Masina car = this.masinaService.getCarbyOwner(owner);
        if(car == null){
            System.out.println("Input new make");
            String make = scanner.nextLine();
            this.masinaService.updateMake(make,car.getOwner());
        }
    }
}
