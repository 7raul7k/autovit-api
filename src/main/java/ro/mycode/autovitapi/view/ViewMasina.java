package ro.mycode.autovitapi.view;


import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.exceptions.CarExistException;
import ro.mycode.autovitapi.exceptions.CarNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.service.MasinaService;

import java.util.List;
import java.util.Scanner;

@Repository
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
        System.out.println("Press 3 to remove car");
        System.out.println("Press 4 to show cars by make");
        System.out.println("Press 5 to update brand");
        System.out.println("Press 6 to update year");


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
                case 3: remove();
                break;
                case 4: showCarsByBrand();
                break;
                case 5: updateBrand();
                break;
                default: play();
            }

        }
    }

    public void afisare(){

        List<Masina> masinas = masinaService.getallCars();

        for(Masina m : masinas){


            System.out.println(m);

        }
    }
    public void add () throws CarExistException, CarNotFoundException {
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
    public void remove() throws CarNotFoundException{
        System.out.println("Input owner");
        String owner = scanner.nextLine();

        this.masinaService.removeCar(owner);
    }

    public void showCarsByBrand() throws CarNotFoundException {
        System.out.println("Input make:");
        String brand = scanner.nextLine();
        List<String> masinas = this.masinaService.getAllCarsByBrand();

        for(String m : masinas){
            System.out.println(m);
        }

    }

    public void updateBrand() throws CarNotFoundException {
        System.out.println("Input owner");
        String owner = scanner.nextLine();
        if(this.masinaService.getCarbyOwner(owner) != null){

            System.out.println("Input new brand");
            String newBrand = scanner.nextLine();

            this.masinaService.updateBrand(newBrand,owner);
        }
    }





}
