package AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import AndesWineTour.entidades.RentarCar;

public interface RentarCarRepositorio extends JpaRepository<RentarCar, String> {

}
