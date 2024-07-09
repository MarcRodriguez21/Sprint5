package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.services;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.domain.Flower;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerServices {

    void addFlower(FlowerDTO flowerDTO);
    void updateFlower(FlowerDTO flowerDTO);
    void deleteFlower(int id);
    FlowerDTO getOneFlower(int id);
    List<FlowerDTO> getAllFlowers();

}

