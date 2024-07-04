package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.repository;

import cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchReopository extends JpaRepository<Branch, Integer> {
}
