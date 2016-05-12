package com.estsoft.guestbook.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;


@Repository
public class GuestbookRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	public void save(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		em.persist(guestbook);
	}
	
	public List<Guestbook> findAll(){
		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb order by gb.regDate desc", Guestbook.class);
		List<Guestbook> list = query.getResultList();
		return list;
	}
	
	public Boolean remove(Guestbook guestbook){
		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb where gb.no = :no and gb.password = :password", Guestbook.class);
		query.setParameter("no", guestbook.getNo());
		query.setParameter("password", guestbook.getPassword());
//		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb where gb.no = ?1 and gb.password = ?2", Guestbook.class);
//		query.setParameter(1, guestbook.getNo());
//		query.setParameter(2, guestbook.getPassword());

//		Guestbook result = query.getSingleResult();         
//		위에거는 결과값이 없거나 여러개이면 에러난다
		List<Guestbook> list = query.getResultList();
		//느려지지않는다 . 캐시되어있기 때문에 이게 끝나야 쿼리가 들어감
		em.remove(list.get(0));
		return true;
	}
}
