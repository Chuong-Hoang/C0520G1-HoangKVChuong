package vn.codegym.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.product.model.Smartphone;
import vn.codegym.product.repository.SmartPhoneRepository;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    SmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone model) {
        return smartPhoneRepository.save(model);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartPhone = this.findById(id);
        smartPhoneRepository.delete(smartPhone);
        return smartPhone;
    }
}
