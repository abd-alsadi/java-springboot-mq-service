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
public class MQRequestDAO{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private MQRequestRepository repo;

    @Autowired
    private MQProducer mqProducer;

    @Autowired
    private EntityManagerFactory emf;

    public MQRequestModel sendMessage(MQRequestModel model,String topic){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();            
            mqProducer.sendMessage(model,topic);
            trans.commit();
            return model;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
      
    }

    public List<MQRequestModel> GetAll(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            List<MQRequestModel> data= repo.findAll();
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }


    public MQRequestModel GetByID(UUID id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
    try{
        trans.begin();
        MQRequestModel data= repo.findById(id).orElse(null);
        trans.commit();
        return data;
    }catch(Exception e){
        trans.rollback();
        throw e;
    }
    }

    public MQRequestModel Add(MQRequestModel object){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            object.setId(UUID.randomUUID()); 
            LocalDate date = LocalDate.now();
            object.setCreatedAt(date.toString());
            object.setUpdatedAt(date.toString());
            trans.begin();
            MQRequestModel data= repo.save(object);
            trans.commit();
            return data;
         }catch(Exception e){
            trans.rollback();
            throw e;
        }        
    }

    public MQRequestModel Delete(UUID id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            MQRequestModel data=GetByID(id);
            trans.begin();
            repo.deleteById(id);
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }

    public MQRequestModel Update(UUID id,MQRequestModel object){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            object.setId(id); 
            LocalDate date = LocalDate.now();
            object.setUpdatedAt(date.toString());
            MQRequestModel data= repo.save(object);
            trans.commit();
            return data;
        }catch(Exception e){
            trans.rollback();
            throw e;
        }
    }
}
