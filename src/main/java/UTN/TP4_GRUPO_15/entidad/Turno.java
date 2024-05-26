package UTN.TP4_GRUPO_15.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@Column(name="id_turno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_turno;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="legajo_medico")
	private Medico medico;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="dni_paciente")
	private Paciente paciente;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="hora")
	private LocalTime hora;
	
	@Column(name="observaciones")
	private String observacion;
	
	@Column(name="estado")
	private String estado;
	
	
	public Turno() {
		
	}
	public Turno(Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora, String observacion, String estado) {
		
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estado = estado;
	}
	
	
	
	
	
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public int getId_turno() {
		return id_turno;
	}
	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Turno [id_turno=" + id_turno + ", medico=" + medico + ", paciente=" + paciente + ", fecha=" + fecha
				+ ", hora=" + hora + ", observacion=" + observacion + ", estado=" + estado + "]";
	}
	
	
	
	
	
	

}
