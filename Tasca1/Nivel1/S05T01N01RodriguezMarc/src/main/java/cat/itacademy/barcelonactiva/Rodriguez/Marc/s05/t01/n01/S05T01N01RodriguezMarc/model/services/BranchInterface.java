package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.services;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.dto.BranchDTO;

import java.util.List;

public interface BranchInterface {

    BranchDTO addBranch(BranchDTO branchDTO);
    void updateBranch(BranchDTO branchDTO);
    boolean deleteBranch(Integer id);
    BranchDTO getOneBranchDTO(Integer id);
    List<BranchDTO> getAllBranches();
}
