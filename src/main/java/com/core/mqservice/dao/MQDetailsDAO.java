package com.core.mqservice.dao;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.core.mqservice.models.*;
import com.core.mqservice.producers.MQProducer;
import com.core.mqservice.repositories.*;

import java.util.*;
import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate; 

@Service
public class MQDetailsDAO{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private MQDetailsRepository repo;

    @Autowired
    private MQProducer mqProducer;

    @Autowired
    private EntityManagerFactory emf;


    public List<MQDetailsModel> GetAll(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            List<MQDetailsModel> data= repo.findAll();
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }


    public MQDetailsModel GetByID(UUID id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
    try{
        trans.begin();
        MQDetailsModel data= repo.findById(id).orElse(null);
        trans.commit();
        return data;
    }catch(Exception e){
        trans.rollback();
        throw e;
    }
    }

    public MQDetailsModel Add(MQDetailsModel object){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            object.setId(UUID.randomUUID()); 
            LocalDate date = LocalDate.now();
            object.setCreatedAt(date.toString());
            object.setUpdatedAt(date.toString());
            trans.begin();
            MQDetailsModel data= repo.save(object);
            trans.commit();
            return data;
         }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }

    public MQDetailsModel Delete(UUID id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            MQDetailsModel data=GetByID(id);
            trans.begin();
            repo.deleteById(id);
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }

    public MQDetailsModel Update(UUID id,MQDetailsModel object){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            object.setId(id); 
            LocalDate date = LocalDate.now();
            object.setUpdatedAt(date.toString());
            MQDetailsModel data= repo.save(object);
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }
}
