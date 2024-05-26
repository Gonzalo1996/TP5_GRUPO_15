package UTN.TP4_GRUPO_15.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medico")	
public class Medico implements Serializable{

	/**
	 * Propiedades
	**/
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="nac")
	private String nac;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;
	
	/**
	 * Constructores
	**/
	
	public Medico() {

	}
	
	public Medico(String nombre, String apellido, String genero, String nac, String correo,
			String direccion, String localidad, String telefono, Usuario usuario, Especialidad especialidad) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.nac = nac;
		this.correo = correo;
		this.direccion = direccion;
		this.localidad = localidad;
		this.telefono = telefono;
		this.usuario = usuario;
		this.especialidad = especialidad;
	}

	/**
	 * Getters and Setters
	**/
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Especialidad getId() {
		return especialidad;
	}

	public void setId(Especialidad id) {
		this.especialidad = id;
	}


	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getNac() {
		return nac;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setNac(String nac) {
		this.nac = nac;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Metodos
	**/
	
	@Override
	public String toString() {
		return "Legajo: " + legajo + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Género: " + genero
				+ ", Nacimiento: " + nac + ", Correo: " + correo + ", Direccion: " + direccion + ", Localidad: " + localidad
				+ ", Telefono: " + telefono;
	}
	
}
