package com.core.mqservice.interfaces;

import com.core.mqservice.models.AuthunticationModel;
import com.core.mqservice.models.MQDetailsModel;

import java.util.*;

public interface IMQDetailsService {
    
    public List<MQDetailsModel> GetAll(AuthunticationModel auth);  

    public MQDetailsModel GetByID(AuthunticationModel auth,UUID id);

    public MQDetailsModel Add(AuthunticationModel auth,MQDetailsModel object);

    public MQDetailsModel Delete(AuthunticationModel auth,UUID id);

    public MQDetailsModel Update(AuthunticationModel auth,UUID id,MQDetailsModel object);
}
