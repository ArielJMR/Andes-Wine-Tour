package AndesWineTour.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cod_Restaurante")
	private String id;
	@Column(name = "Nombre_Restaurante")
	private String nombre;
	@Column(name = "Direccion_Restaurante")
	private String direccion;
	@Column(name = "Telefono_Restaurante")
	private String telefono;
	@Column(name = "Correo_Restaurante")
	private String correo;
	@Column(name = "Link_Restaurante")
	private String link;
	@OneToMany
	private List<Foto> foto = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "Cod_Departamento")
	private Departamento departamento;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Foto> getFoto() {
		return foto;
	}
	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	
}
