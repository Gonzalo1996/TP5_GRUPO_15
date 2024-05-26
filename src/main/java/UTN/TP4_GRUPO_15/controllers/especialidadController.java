package UTN.TP4_GRUPO_15.controllers;

import org.hibernate.Session;

import UTN.TP4_GRUPO_15.dao.ConfigHibernate;
import UTN.TP4_GRUPO_15.entidad.Especialidad;
import UTN.TP4_GRUPO_15.entidad.Medico;

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
	
	public Especialidad readOne(int id) {
		
		try {
			ConfigHibernate ch = new ConfigHibernate(Especialidad.class);
			
			Session session = ch.openSession();
			session.beginTransaction();
			
			Especialidad especialidad = (Especialidad)session.get(Especialidad.class, id);
			ch.closeSession();
			
			return especialidad;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public String delete(int id) {
		
		ConfigHibernate ch = new ConfigHibernate(Especialidad.class);
		Session session = ch.openSession();
		
		session.beginTransaction();
		Especialidad especialidad = readOne(id);
		session.delete(especialidad);
		session.getTransaction().commit();
		ch.closeSession();
		
		return "Registro eliminado";
		
	}
}
