package UTN.TP4_GRUPO_15.controllers;


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
	
}
