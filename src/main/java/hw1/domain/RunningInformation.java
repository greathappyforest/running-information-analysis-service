package hw1.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {

    private String runningId;
    private String totalRunningTime;
    private long heartRate;
    @Id
    @GeneratedValue
    private long userId;
    private String userName;
    private String userAddress;
    private String HealthWarningLevel;


    public RunningInformation() {}

    @JsonCreator
    public RunningInformation(@JsonProperty("heartRate") long heartRate, @JsonProperty("userInfo") UserInfo userInfo) {
        this.userName=userInfo.getUsername();
        this.userAddress=userInfo.getAddress();

        if (heartRate == 0)
            this.heartRate = 60 + (long) (Math.random() * (140 + 1));
        else
            this.heartRate = heartRate;

        //HealthWarningLevel
        if(this.heartRate>=60 && this.heartRate<=75)
            this.HealthWarningLevel="LOW";
        else if(this.heartRate>75 && this.heartRate<=120)
            this.HealthWarningLevel="NORMAL";
        else if(this.heartRate>120)
            this.HealthWarningLevel="HIGH";
        else
            this.HealthWarningLevel="UNKNOWN";
    }



}
