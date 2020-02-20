package AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import AndesWineTour.entidades.Hotel;

public interface HotelRepositorio extends JpaRepository<Hotel, String>{

}
