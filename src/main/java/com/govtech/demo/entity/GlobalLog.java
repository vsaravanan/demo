package com.govtech.demo.entity;

import com.govtech.demo.util.Common;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Sarav on 10 Aug 2022
 * @project govtech
 * @package com.govtech.viswa.entity
 * @class GlobalLog
 */

@Entity
@Data
@NoArgsConstructor
@EntityListeners( AuditingEntityListener.class )
@Log4j2
public class GlobalLog  {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    Long logId;
    String  message;
    String  warning;
    String  path;
    String  input;

    @CreatedBy
    String createdBy;

    @CreatedDate
    LocalDateTime createdTm;
    String  description;



    public GlobalLog(String description, String message, String warning, String path, String input) {
        this.description = Common.left( description, 11900 );
        this.message = message;
        this.warning = warning;
        this.path = path;
        this.input = input;
        log.info( this );
    }



    @Override
    public String toString () {

        return String.format("""
        GlobalLog { 
            logId=%d, 
            message='%s', 
            warning='%s', 
            path='%s', 
            input='%s', 
            createdBy='%s', createdTm=%s,  
            description='%s' 
        }
        """, logId, message, warning, path, input, createdBy, createdTm, description );
    }

}
