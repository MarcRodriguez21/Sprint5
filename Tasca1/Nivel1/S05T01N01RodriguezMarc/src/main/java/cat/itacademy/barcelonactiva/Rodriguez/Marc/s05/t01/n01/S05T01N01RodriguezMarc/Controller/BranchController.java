package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.Controller;


import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.services.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchServices;

    @GetMapping("/home")
    public String showIndex(Model model) {
        model.addAttribute("branches", branchServices.getAllBranches());
        return "index";
    }
    @GetMapping("/addBranchForm")
    public String showAddBranchForm(Model model) {
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("newBranch", branchDTO);
        return "addBranchForm";
    }
    @PostMapping("/add")
    public String addBranch(@ModelAttribute("newBranch") BranchDTO branchDTO) {
        branchServices.addBranch(branchDTO);
        return "redirect:/branches/home";
    }
    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable String id) {
        branchServices.deleteBranch(Integer.valueOf(id));

        return "redirect:/branches/home";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        BranchDTO branch = branchServices.getOneBranchDTO(id);

        model.addAttribute("branchToUpdate", branch);

        return "editBranchForm";
    }

    @PostMapping("/update")
    public String updateBranch(@ModelAttribute("branchToUpdate") BranchDTO branchDTO) {
        branchServices.updateBranch(branchDTO);
        return "redirect:/branches/home";
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable int id) {
        Optional<BranchDTO> branch = Optional.ofNullable(branchServices.getOneBranchDTO(id));
        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<BranchDTO>> getAllBranches() {
        List<BranchDTO> branches = branchServices.getAllBranches();
        return ResponseEntity.ok(branches);
    }
}
