package UTN.TP4_GRUPO_15.controllers;

import org.hibernate.Session;

import UTN.TP4_GRUPO_15.dao.ConfigHibernate;
import UTN.TP4_GRUPO_15.entidad.Especialidad;

public class especialidadController {

	public String create(Especialidad especialidad)
	{
		
		try
		{
			ConfigHibernate ch = new ConfigHibernate(Especialidad.class);
			Session session = ch.openSession();
			
			session.beginTransaction();
			session.save(especialidad);
			
			session.getTransaction().commit();
			ch.closeSession();

			return "Especialidad creada";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error al cargar especialidad";
		}
		
	}
}
