/*package com.quizcampen.service.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;



@Stateless(name = "DAOServiceEJB")
@Local({ DAOServiceLocal.class })
public class DAOServiceBean implements DAOServiceLocal{

	@PersistenceContext(unitName = "QuizcampenSpelDB")
	private EntityManager entityManager;
	

	@Override
	public Object save(Object object) {
	
		return this.entityManager.merge(object);
	}
	
	public void delete(Object object) {
		
		this.entityManager.remove(this.entityManager.contains(object) ? object : entityManager.merge(object));
	}
	

	@Override
	public QuizcampenQuestionDAO getQuiestionByRow(String question) {
		
		String sql = "SELECT * FROM QUIZCAPEN_QUES_ANS WHERE question='"+question+"'";
		
		Query q = this.entityManager.createNativeQuery(sql, QuizcampenQuestionDAO.class);
		
		List l = q.getResultList();
		
		if(l !=null && !l.isEmpty()) {
			return (QuizcampenQuestionDAO) l.get(0);
		}else {
		
		return null;
		}
	}

}*/



