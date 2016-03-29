package com.beyondalgo.hibernate.customidgeneration;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyIdGenerator implements IdentifierGenerator{

	public int generateCustId() {
        Random random = new Random();
        return random.nextInt(100);
    }
	
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		
		Date date = new Date();
        
        Calendar calendar = Calendar.getInstance();
        return "Cust_" + this.generateCustId() + "_" + calendar.get(Calendar.YEAR);
	}

}
