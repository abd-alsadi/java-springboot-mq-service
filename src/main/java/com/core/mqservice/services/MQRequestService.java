package com.core.mqservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.mqservice.interfaces.IMQRequestService;
import com.core.mqservice.models.AuthunticationModel;
import com.core.mqservice.models.MQDetailsModel;
import com.core.mqservice.models.MQRequestModel;
import com.core.mqservice.dao.MQRequestDAO;
import java.util.*;

@Service
public class MQRequestService implements IMQRequestService {
    
    @Autowired
    MQRequestDAO DAO;

    @Autowired
    MQDetailsService detailsService;
    
    @Override
    public MQRequestModel sendMessage(AuthunticationModel auth,MQRequestModel model,String topic){
        MQRequestModel data = Add(auth,model);
        MQDetailsModel details = new MQDetailsModel();
        details.setRequestID(data.getId());
        details.setStatus("to-do");
        detailsService.Add(auth,details);
        DAO.sendMessage(data,topic);
        return data;
    }
    @Override
    public List<MQRequestModel> GetAll(AuthunticationModel auth){
        List<MQRequestModel> data= DAO.GetAll();
        return data;
    }    


    @Override
    public MQRequestModel GetByID(AuthunticationModel auth,UUID id){
        MQRequestModel data= DAO.GetByID(id);
        return data;
    }

    @Override
    public MQRequestModel Add(AuthunticationModel auth,MQRequestModel object){
        object.setClientID(auth.getClient_id());
        object.setToken(auth.getTokenValue());
        MQRequestModel data= DAO.Add(object);
        return data;
        
    }

    @Override
    public MQRequestModel Delete(AuthunticationModel auth,UUID id){
        MQRequestModel data= DAO.Delete(id);
        return data;
    }

    @Override
    public MQRequestModel Update(AuthunticationModel auth,UUID id,MQRequestModel object){
        object.setClientID(auth.getClient_id());
        object.setToken(auth.getTokenValue());
        MQRequestModel data= DAO.Update(id,object);
        return data;
    }
}
