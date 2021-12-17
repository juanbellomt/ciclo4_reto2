package co.usa.ciclo4.reto2.service;

import co.usa.ciclo4.reto2.model.Cookware;
import co.usa.ciclo4.reto2.repository.CookwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CookwareService {

    @Autowired
    private CookwareRepository cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return cookwareRepository.getCookware(reference);
    }

    public Cookware create(Cookware cookware) {
        if (cookware.getReference() == null) {
            return cookware;
        }else {
            return cookwareRepository.create(cookware);
        }
    }

    public Cookware update(Cookware cookware) {
        if (cookware.getReference() != null) {
            Optional<Cookware> cookwareDB = cookwareRepository.getCookware(cookware.getReference());
            if (!cookwareDB.isEmpty()) {
                if (cookware.getBrand()!= null) {
                    cookwareDB.get().setBrand(cookware.getBrand());
                }
                if (cookware.getCategory() != null) {
                    cookwareDB.get().setCategory(cookware.getCategory());
                }
                if (cookware.getMateriales() != null) {
                    cookwareDB.get().setMateriales(cookware.getMateriales());
                }
                if (cookware.getDimensiones() != null) {
                    cookwareDB.get().setDimensiones(cookware.getDimensiones());
                }
                if (cookware.getDescription() != null) {
                    cookwareDB.get().setDescription(cookware.getDescription());
                }
                if (cookware.getPrice() != 0.0) {
                    cookwareDB.get().setPrice(cookware.getPrice());
                }
                if (cookware.getQuantity() != 0) {
                    cookwareDB.get().setQuantity(cookware.getQuantity());
                }
                if (cookware.getPhotography() != null) {
                    cookwareDB.get().setPhotography(cookware.getPhotography());
                }
                cookwareDB.get().setAvailability(cookware.isAvailability());
                cookwareRepository.update(cookwareDB.get());
                return cookwareDB.get();
            }else {
                return cookware;
            }
        }else {
            return cookware;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCookware(reference).map(cookware -> {
            cookwareRepository.delete(cookware);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
