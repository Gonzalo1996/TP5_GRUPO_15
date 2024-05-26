package UTN.TP4_GRUPO_15.controllers;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import UTN.TP4_GRUPO_15.dao.ConfigHibernate;
import UTN.TP4_GRUPO_15.entidad.Especialidad;
import UTN.TP4_GRUPO_15.entidad.Medico;
import UTN.TP4_GRUPO_15.entidad.Paciente;
import UTN.TP4_GRUPO_15.entidad.Turno;
import UTN.TP4_GRUPO_15.entidad.Usuario;

public class turnoController {
	
	public String create(Turno turno)
	{
		
		try
		{
			ConfigHibernate ch = new ConfigHibernate(Turno.class, Paciente.class, Medico.class, Especialidad.class, Usuario.class);
			Session session = ch.openSession();
			
			session.beginTransaction();
			session.save(turno);
			
			session.getTransaction().commit();
			ch.closeSession();

			return "Turno creado";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error al crear turno";
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void listTurnosInnerJoin() {
		
		try {
			
			ConfigHibernate ch = new ConfigHibernate(Especialidad.class);
			
			Session session = ch.openSession();
			session.beginTransaction();
			String query = "FROM Turno AS t "
						 + "INNER JOIN t.medico AS m "
						 + "WHERE m.legajo = :legajo AND t.fecha = :fecha";
			
			List<Object[]> listTurnos = (List<Object[]>) session.createQuery(query)
										.setParameter("legajo", 1234)
										.setParameter("fecha", LocalDate.of(2025, 01, 01))
										.list();
			
			System.out.println("-------------- LISTA DE TURNOS--------------------");
			
			for (Object[] object : listTurnos) {
				
				Turno turno = (Turno) object[0];
				Medico medico = (Medico) object[1];
				
				System.out.println("Turno Medico legajo: " + medico.getLegajo() + ". Fecha: " + turno.getFecha() + ". Estado: " + turno.getEstado());
				
			}
			
			ch.closeSession();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
}
