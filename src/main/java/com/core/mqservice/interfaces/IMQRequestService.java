package com.core.mqservice.interfaces;

import com.core.mqservice.models.AuthunticationModel;
import com.core.mqservice.models.MQRequestModel;

import java.util.*;

public interface IMQRequestService {
    
    public MQRequestModel sendMessage(AuthunticationModel auth,MQRequestModel msg,String topic);

    public List<MQRequestModel> GetAll(AuthunticationModel auth);  

    public MQRequestModel GetByID(AuthunticationModel auth,UUID id);

    public MQRequestModel Add(AuthunticationModel auth,MQRequestModel object);

    public MQRequestModel Delete(AuthunticationModel auth,UUID id);

    public MQRequestModel Update(AuthunticationModel auth,UUID id,MQRequestModel object);
}
