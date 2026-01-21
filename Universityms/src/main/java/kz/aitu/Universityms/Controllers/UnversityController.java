package kz.aitu.Universityms.Controllers;

import kz.aitu.Universityms.entities.Univer;
import org.springframework.web.bind.annotation.*;

@RestController

public class UnversityController {
    @PostMapping("/addUni")
    public String addUni(@RequestBody Univer univer) {
        dbms.addUni(univer.getName(), univer.getLocation(), univer.getRating());

        return dbms.getUniversityInfo();
    };

    @PostMapping("/changeRating")
    public String ChangeRating(@RequestBody Univer univer) {
        dbms.updateUniRating(univer.getName(), univer.getRating());

        return dbms.getUniversityInfo();
    }

    @PostMapping("/dropUni")
    public String DropUni(@RequestBody Univer univer) {
        dbms.dropUni(univer.getName());

        return dbms.getUniversityInfo();
    };

    @PostMapping("/getUniInfo")
    public String GetUniInfo() {
        return dbms.getUniversityInfo();
    };

}
