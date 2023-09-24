package com.core.mqservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.core.mqservice.models.*;
import java.util.*;


@Repository
@Transactional
public interface MQDetailsRepository extends JpaRepository<MQDetailsModel,UUID>{
    
}