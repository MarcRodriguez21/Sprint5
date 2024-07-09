package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.controller;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.services.FlowerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FlowerController {

    @Autowired
    private FlowerServices flowerService;

    @PostMapping("/add")
    public ResponseEntity<String> addFlower(@RequestBody FlowerDTO flowerDTO) {
        flowerService.addFlower(flowerDTO);
        return ResponseEntity.ok("flower added");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFlower(@RequestBody FlowerDTO flowerDTO) {
        flowerService.updateFlower(flowerDTO);
        return ResponseEntity.ok("flower updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        flowerService.deleteFlower(id);
        return ResponseEntity.ok("Fruit deleted");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDTO> getFruitById(@PathVariable int id) {
        FlowerDTO flowerDTO = flowerService.getOneFlower(id);
        return ResponseEntity.ok().body(flowerDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> getAllFruits() {
        List<FlowerDTO> flowers = flowerService.getAllFlowers();
        return ResponseEntity.ok(flowers);
    }

}