package UTN.TP4_GRUPO_15.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public static void listTurnStatusPercentages(){
		System.out.println("Listando el porcentaje de ausentes y presentes de los turnos...\n");
		ConfigHibernate ch = new ConfigHibernate(Turno.class);
		Session session = ch.openSession();
		session.beginTransaction();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<Turno> lista = (List<Turno>) session.createQuery("FROM Turno t WHERE t.fecha BETWEEN :startDate AND :endDate AND t.estado IN ('presente', 'ausente')")
				.setParameter("startDate", LocalDate.of(2024, 01, 01))
				.setParameter("endDate", LocalDate.of(2024, 03, 01))
				.list();
		
		int turnosPresente = 0;
		int turnosAusente = 0;
		for(Turno turno : lista) {
			if("presente".equals(turno.getEstado())) {
				turnosPresente ++;
			}
			else {
				turnosAusente ++;
			}
		}
		
		int turnosTotales = turnosPresente + turnosAusente;
		
		if(turnosTotales == 0) 
		{
			System.out.println("No se encontraron turnos entre esas fechas.");
			return;
		}
		
		System.out.println("Porcentaje de presentes: %" + String.format("%.2f", (turnosPresente * 100.0) / turnosTotales));
		System.out.println("Porcentaje de ausentes: %" + String.format("%.2f", (turnosAusente * 100.0) / turnosTotales));
	}
	
}
