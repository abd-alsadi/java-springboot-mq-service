package com.core.mqservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.mqservice.interfaces.IMQDetailsService;
import com.core.mqservice.models.AuthunticationModel;
import com.core.mqservice.models.MQDetailsModel;
import com.core.mqservice.dao.MQDetailsDAO;
import java.util.*;

@Service
public class MQDetailsService implements IMQDetailsService {
    
    @Autowired
    MQDetailsDAO DAO;
    

    @Override
    public List<MQDetailsModel> GetAll(AuthunticationModel auth){
        List<MQDetailsModel> data= DAO.GetAll();
        return data;
    }    


    @Override
    public MQDetailsModel GetByID(AuthunticationModel auth,UUID id){
        MQDetailsModel data= DAO.GetByID(id);
        return data;
    }

    @Override
    public MQDetailsModel Add(AuthunticationModel auth,MQDetailsModel object){
        MQDetailsModel data= DAO.Add(object);
        return data;
        
    }

    @Override
    public MQDetailsModel Delete(AuthunticationModel auth,UUID id){
        MQDetailsModel data= DAO.Delete(id);
        return data;
    }

    @Override
    public MQDetailsModel Update(AuthunticationModel auth,UUID id,MQDetailsModel object){
        MQDetailsModel data= DAO.Update(id,object);
        return data;
    }
}
