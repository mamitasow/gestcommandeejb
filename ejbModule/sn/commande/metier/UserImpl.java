package sn.commande.metier;




import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sn.commande.entities.User;

@Stateless
public class UserImpl implements IUserLocal, IUserRemote{

	
	@PersistenceContext(unitName="Gest_CommandeEJB")
	private EntityManager em;
	
	@Override
	public int add(User user) {
		int ok = 0;
		try 
		{
			em.persist(user);
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return ok;
	}

	@Override
	public int update(User user) {
		int ok = 0;
		try 
		{
			em.merge(em.find(User.class, user.getId()));
			
		
			/********
			String sql = "UPDATE USER u SET nom=?, prenom=?, email=?, password=? WHERE id=?";
			//Query q = em.createQuery(sql);
			Query qu = em.createQuery(sql);
			qu.setParameter(1, user.getNom());	
			qu.setParameter(1, user.getPrenom());	
			qu.setParameter(1, user.getEmail());	
			qu.setParameter(1, user.getPassword());	
			qu.setParameter(1, user.getId());
			
				if(request.getSession().getAttribute("user_session")!=null) {
			User user =(User)request.getSession().getAttribute("user_session");
			request.setAttribute("user",user);
			
			 <li> <a href="">
                         <c:if test ="${user.prenom !=null}">
                          Bienvenue ${user.prenom}  ${user.nom}
                          </c:if>
                         </a></li> 
                         
                          request.getSession().setAttribute("user_session",user);
			*****/
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return ok;
	}

	@Override
	public int delete(int id) {
		int ok = 0;
		try 
		{
			em.remove(em.find(User.class, id));
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return ok;
	}

	@Override
	public User get(int id) {
		
		return em.find(User.class,id);
	}

	@Override
	public List<User> liste()   {
		
		return em.createQuery("SELECT u FROM User u").getResultList();
		//return em.createNamedQuery("User.findAll").getResultList();
		//List<User> user = em.createQuery("SELECT u FROM User u").getResultList();
		
		//return user;
		
			//TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		//return query.getResultList();
	
		
	}

	@Override
	public User verifUser(String email, String password) {
		// TODO Auto-generated method stub
		return(User)em.createNamedQuery("User.login")
				.setParameter("email",email)
				.setParameter("password",password).getSingleResult() ;

	}

	@Override
	public List<User> recherche(String motCle) {
		// TODO Auto-generated method stub
	//return em.createQuery("SELECT u FROM User u WHERE prenom LIKE "+"%"+motCle+"%").getResultList();
	//Query q = em.createQuery("SELECT u FROM User u WHERE prenom LIKE :motcle");
		
		
		
		String sql = "SELECT u FROM User u WHERE u.prenom LIKE?";
		//Query q = em.createQuery(sql);
		Query qu = em.createQuery(sql);
		qu.setParameter(1, "%"+motCle+"%");
		
		return qu.getResultList();
		
		
	}

	

}
