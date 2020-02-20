package AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import AndesWineTour.entidades.Restaurante;

public interface RestauranteRepositorio extends JpaRepository<Restaurante, String> {

}
