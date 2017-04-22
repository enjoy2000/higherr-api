package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
public class Application extends BaseModel {

    private @ManyToOne(cascade={CascadeType.ALL}) Job job;
    private @ManyToOne(cascade={CascadeType.ALL}) User applicant;
    private @ManyToOne(cascade={CascadeType.ALL}) User referrer;
    private String additionalDocLocation; //uploading additional file from application
    private String[] referralAnswer;

    private Application() {}


    public Application(Job job, User applicant, User referrer, String additionalDocLocation, String[] referralAnswer) {
        this.job = job;
        this.applicant = applicant;
        this.referrer = referrer;
        this.additionalDocLocation = additionalDocLocation;
        this.referralAnswer = referralAnswer;
    }
}
