package ro.mycode.autovitapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.autovitapi.dto.MasinaDTO;
import ro.mycode.autovitapi.exceptions.CarNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.service.MasinaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MasinaResource {

    private MasinaService masinaService;

    public MasinaResource(MasinaService masinaService) {
        this.masinaService = masinaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Masina>> getAllCars(){
        List<Masina> masini= this.masinaService.getallCars();
        return new ResponseEntity<>(masini,HttpStatus.OK );
    }

    @GetMapping("/brand")
    public ResponseEntity<List<String>> getAllCarsBrand() {

        List<String> masini = null;
        try {
            masini = this.masinaService.getAllCarsByBrand();
            return new ResponseEntity<>(masini,HttpStatus.OK);
        } catch (CarNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/color")
    public ResponseEntity<List<String>> getAllCarsColors()  {
        List<String> masini = null;
        try {
            masini = this.masinaService.showCarbyColor();
            return new ResponseEntity<>(masini,HttpStatus.OK);
        } catch (CarNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/year")
    public ResponseEntity<List<String>> getAllCarsYears() {
        List<String> masini = null;
        try {
            masini = this.masinaService.showAllCarByYear();
            return new ResponseEntity<>(masini,HttpStatus.OK);
        } catch (CarNotFoundException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/masini/{owner}")
    public ResponseEntity<Masina> getAllCarsByOwner(@PathVariable String owner) throws CarNotFoundException {

        Masina m = this.masinaService.getCarbyOwner(owner);
        return new ResponseEntity<>(m,HttpStatus.OK);


    }

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody MasinaDTO masinaDTO){

        this.masinaService.addCar(masinaDTO);

        return new ResponseEntity<>("Masina a fost Adaugata",HttpStatus.OK);
    }



}
