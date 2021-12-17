package co.usa.ciclo4.reto2.web;

import co.usa.ciclo4.reto2.model.Cookware;
import co.usa.ciclo4.reto2.service.CookwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class CookwareController {

    @Autowired
    private CookwareService cookwareService;

    @GetMapping("/all")
    public List<Cookware> getAll() {
        return cookwareService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cookware> getCookware(@PathVariable("reference") String reference) {
        return cookwareService.getCookware(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware create(@RequestBody Cookware cookware) {
        return cookwareService.create(cookware);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update(@RequestBody Cookware cookware) {
        return cookwareService.update(cookware);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cookwareService.delete(reference);
    }

}
