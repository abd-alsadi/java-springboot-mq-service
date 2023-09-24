package com.core.mqservice.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "mq_details")
public class MQDetailsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String TableName="mq_details";

    @Id
    @Column(name = "flduid")
    private UUID  id;

    @Column(name = "fldrequestid")
    private UUID  requestID;

    @Column(name = "fldstatus")
    private String  status;

    @Column(name = "fldflag")
    private int flag;

    @Column(name = "fldcreatedat")
    private String createdAt;

    @Column(name = "fldupdatedat")
    private String updatedAt;

    
    // @Override
    // public String toString(){
    //     return "MessageModel{"
    //      +"id='"+ this.id+"',"
    //      +"source='"+ this.source+"',"
    //      +"createdAt='"+ this.createdAt+"',"
    //      +"details='"+ this.details+"',"
    //      +"flag='"+ this.flag+"',"
    //      +"message='"+ this.message+"',"
    //      +"status='"+ this.status+"',"
    //      +"topic='"+ this.topic+"'"
    //     +"}";
    // }
}
