package UTN.TP4_GRUPO_15.controllers;

import java.util.List;

import org.hibernate.Session;

import UTN.TP4_GRUPO_15.dao.ConfigHibernate;
import UTN.TP4_GRUPO_15.entidad.Medico;
import UTN.TP4_GRUPO_15.entidad.Usuario;

public class usuarioController {
	
	public String create(Usuario usuario)
	{
		
		try
		{
			ConfigHibernate ch = new ConfigHibernate(Usuario.class);
			Session session = ch.openSession();
			
			session.beginTransaction();
			session.save(usuario);
			
			session.getTransaction().commit();
			ch.closeSession();

			return "Usuario creado";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error al cargar usuario";
		}
		
	}

}
