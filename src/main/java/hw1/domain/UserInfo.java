package hw1.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String username;
    private String address;

    public UserInfo(){}

    public UserInfo( UserInfo userInfo) {
        this.username = userInfo.username;
        this.address = userInfo.address;
    }

}
