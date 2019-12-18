package com.quizcampen;


import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import com.quizcampen.entities.Quiz;
import com.quizcampen.service.dao.DAOServiceLocal;

public class QuizcampenService {
	
	public static final QuizcampenService INSTANCE = new QuizcampenService();
	
	private static Logger _log = Logger.getLogger(QuizcampenService.class);
	
	public static List<Quiz> Quizcapmen = null;

	private DAOServiceLocal daoService;
	
	QuizcampenService(){
		initService();
	}
	
	public void initService() {
		try {
		    Context ctx = new InitialContext();
		    String current = "java:global/Quizcampen/DAOServiceEJB!com.quizcampen.service.dao.DAOServiceLocal";
		    this.daoService = ((DAOServiceLocal) ctx.lookup(current));

		} catch (Exception e) {
		    _log.error(e.getMessage());
		}
	    }
}
