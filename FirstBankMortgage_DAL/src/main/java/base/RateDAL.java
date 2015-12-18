package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {

	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;
		
		try {
			tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where rateId = :id ");
			
			List<?> list = query.list();
			rateGet = (RateDomainModel)list.get(0);
			
						
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		if (GivenCreditScore >= 600 & GivenCreditScore < 650){
			rateGet.setRateID(1);
			rateGet.setInterestRate(.05);
		}
		else if (GivenCreditScore >= 650 & GivenCreditScore < 700){
			rateGet.setRateID(2);
			rateGet.setInterestRate(.045);
		}
		else if (GivenCreditScore >= 700 & GivenCreditScore < 750){
			rateGet.setRateID(3);
			rateGet.setInterestRate(.04);
		}
		else if (GivenCreditScore >= 750 & GivenCreditScore < 800){
			rateGet.setRateID(4);
			rateGet.setInterestRate(.0375);
		}
		else if (GivenCreditScore >= 800){
			rateGet.setRateID(5);
			rateGet.setInterestRate(.035);
		}
	 return rateGet.getInterestRate();
	}
	

}