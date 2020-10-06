package vn.codegym.product.service;
import vn.codegym.product.model.Smartphone;

public interface SmartPhoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone model);
    Smartphone remove(Integer id);
}
