package vn.codegym.picture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.picture.model.NasaPicture;

public interface NasaPictureRepository extends JpaRepository<NasaPicture, Integer> {
}
