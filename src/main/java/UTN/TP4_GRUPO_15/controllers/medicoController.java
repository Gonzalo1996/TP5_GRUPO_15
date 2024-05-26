package UTN.TP4_GRUPO_15.controllers;

import java.util.List;

import org.hibernate.Session;

import UTN.TP4_GRUPO_15.dao.ConfigHibernate;
import UTN.TP4_GRUPO_15.entidad.Especialidad;
import UTN.TP4_GRUPO_15.entidad.Medico;
import UTN.TP4_GRUPO_15.entidad.Usuario;

public class medicoController {
	
	public String create(Medico medico)
	{
		
		try
		{
			ConfigHibernate ch = new ConfigHibernate(Medico.class, Usuario.class, Especialidad.class);
			Session session = ch.openSession();
			
			session.beginTransaction();
			session.save(medico);
			
			session.getTransaction().commit();
			ch.closeSession();

			return "medico creado";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error con la carga del medico";
		}
		
	}
	
	public Medico readOne(int id) {
		
		try {
			ConfigHibernate ch = new ConfigHibernate(Medico.class);
			
			Session session = ch.openSession();
			session.beginTransaction();
			
			Medico medico = (Medico)session.get(Medico.class, id);
			ch.closeSession();
			
			return medico;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<Medico> listMedicos() {
		
		ConfigHibernate ch = new ConfigHibernate(Medico.class);
		
		Session session = ch.openSession();
		session.beginTransaction();
		List<Medico> medicos = session.createQuery("FROM Medico").list();
        session.getTransaction().commit();
        
        ch.closeSession();
        return medicos;
	}
	
	public String update(Medico medico) {
		ConfigHibernate ch = new ConfigHibernate(Medico.class);
		
		Session session = ch.openSession();
		
		session.beginTransaction();
        session.update(medico);
        session.getTransaction().commit();
        
        ch.closeSession();
        
        return "Registro actualizado correctamente";
	}
	
	public String delete(int id) {
		
		ConfigHibernate ch = new ConfigHibernate(Medico.class);
		Session session = ch.openSession();
		
		session.beginTransaction();
		Medico medico = readOne(id);
		session.delete(medico);
		session.getTransaction().commit();
		ch.closeSession();
		
		return "Registro eliminado";
		
	}

}
