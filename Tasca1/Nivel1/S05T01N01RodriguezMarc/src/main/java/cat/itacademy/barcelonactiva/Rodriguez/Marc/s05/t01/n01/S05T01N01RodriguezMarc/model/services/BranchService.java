package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.services;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.exceptions.BranchNotFoundException;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.domain.Branch;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.repository.BranchReopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService implements BranchInterface {
    @Autowired
    private BranchReopository branchReopository;
    @Override
    public BranchDTO addBranch(BranchDTO branchDTO) {
        Branch branch = new Branch(branchDTO.getBranchName(), branchDTO.getBranchCountry());
        branchReopository.save(branch);
        return branchDTO;
    }
    @Override
    public void updateBranch(BranchDTO branchDTO) {
        Optional<Branch> optionalBranch = branchReopository.findById(branchDTO.getBranchId());
        if (optionalBranch.isPresent()) {
            Branch existingBranch = optionalBranch.get();
            existingBranch.setBranchName(branchDTO.getBranchName());
            existingBranch.setBranchCountry(branchDTO.getBranchCountry());
            branchReopository.save(existingBranch);
        } else {
            throw new RuntimeException("No se encontró la sucursal con ID: " + branchDTO.getBranchId());
        }
    }
    @Override
    public boolean deleteBranch(Integer id) {
        if(!branchReopository.existsById(id)){
            throw new BranchNotFoundException("Branch not found");
        }
        branchReopository.deleteById(id);
        return true;
    }
    @Override
    public BranchDTO getOneBranchDTO(Integer id) {
        Optional<Branch> branch = branchReopository.findById(id);
        if(!branch.isPresent()){
            throw new BranchNotFoundException("Branch not found");
        }
        return new BranchDTO(branch.get().getBranchId(), branch.get().getBranchName(), branch.get().getBranchCountry());
    }
    @Override
    public List<BranchDTO> getAllBranches() {
        List<Branch> branchList = branchReopository.findAll();
        List<BranchDTO> branchDTOList = new ArrayList<>();
        for(Branch branch : branchList){
            branchDTOList.add(new BranchDTO(branch.getBranchId(), branch.getBranchName(), branch.getBranchCountry()));

        }
        return branchDTOList;
    }
}
