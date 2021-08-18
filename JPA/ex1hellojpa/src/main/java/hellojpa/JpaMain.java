package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member member = new Member();
//        member.setId(2L);
//        member.setName("Kim");
//        em.persist(member);
//        tx.commit();
//
//        try{
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("Jin");
//            em.persist(member);
//            tx.commit();
//            em.close();
//        try{
////            Member a = em.find(Member.class, 1L);
////            System.out.println(a.getName());
//
//            TypedQuery<Member> query = em.createQuery("select m from Member as m", Member.class);
//            List<Member> members = query.getResultList();
//            tx.commit();
//            System.out.println(members);
//
//        }catch(Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        try{
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


        emf.close();
    }
}
