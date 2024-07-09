package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.services.impl;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.domain.Flower;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.repository.FlowerRepository;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n02.S05T01N02RodriguezMarc.model.services.FlowerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlowerServicesImpl implements FlowerServices {
    @Autowired
    private FlowerRepository flowerRepo;

    @Override
    public void addFlower(FlowerDTO flowerDTO) {
        Flower flower = new Flower(flowerDTO.getName(),flowerDTO.getCountry());
        flowerRepo.save(flower);
    }

    @Override
    public void updateFlower(FlowerDTO flowerDTO) {
        Flower existingFlower = flowerRepo.findById(flowerDTO.getId())
                .orElseThrow(() -> new FlowerNotFoundException("No flower found with id: " + flowerDTO.getId()));
        existingFlower.setName(flowerDTO.getName());
        existingFlower.setCountry(flowerDTO.getCountry());
        flowerRepo.save(existingFlower);
    }

    @Override
    public void deleteFlower(int id) {
        Flower existingFlower = flowerRepo.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("No flower found with id: " + id));
        flowerRepo.delete(existingFlower);

    }

    @Override
    public FlowerDTO getOneFlower(int id) {
        Optional<Flower> flower = flowerRepo.findById(id);
        if (flower.isPresent()) {
            FlowerDTO flowerDTO = new FlowerDTO(flower.get().getName(), flower.get().getCountry());
            flowerDTO.setId(flower.get().getId());
            return flowerDTO;
        } else {
            throw new FlowerNotFoundException("No flower found with id: " + id);
        }

    }
    @Override
    public List<FlowerDTO> getAllFlowers() {
        List<Flower> flowers = flowerRepo.findAll();
        List<FlowerDTO> flowersDTO = new ArrayList<>();
        for(Flower flower : flowers) {
            FlowerDTO flowerDTO = new FlowerDTO(flower.getName(), flower.getCountry());
            flowerDTO.setId(flower.getId());
            flowersDTO.add(flowerDTO);
        }
        return flowersDTO;
    }
}