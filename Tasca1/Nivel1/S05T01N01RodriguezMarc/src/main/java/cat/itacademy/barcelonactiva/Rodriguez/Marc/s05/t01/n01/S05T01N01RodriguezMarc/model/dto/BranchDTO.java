package cat.itacademy.barcelonactiva.Rodriguez.Marc.s05.t01.n01.S05T01N01RodriguezMarc.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDTO {

    private int branchId;
    @Column(name = "Branch_name")
    private String branchName;
    @Column(name = "Branch_country")
    private String branchCountry;
    private String branchType;
    private static final List<String> euCountries = new ArrayList<>(Arrays.asList("portugal","spain","france",
            "austria","germany","italy","greece", "belgium", "bulgaria", "croatia", "republic of cyprus",
            "czech republic", "denmark", "estonia", "finland", "hungary", "ireland", "latvia", "lithuania",
            "luxembourg", "malta", "netherlands", "poland", "romania", "slovakia", "slovenia", "sweden"));

    public BranchDTO(int branchId, String branchName, String branchCountry) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
        this.branchType = euCountries.contains(branchCountry) ? "EU" : "Not EU";
    }
    public BranchDTO() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCountry() {
        return branchCountry;
    }
    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    public String getBranchType() {
        return branchType;
    }
    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", branchCountry='" + branchCountry + '\'' +
                ", branchType='" + branchType + '\'' +
                '}';
    }
}
