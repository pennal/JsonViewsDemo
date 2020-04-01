package org.lp.viewTest.models;

import com.fasterxml.jackson.annotation.JsonView;
import org.lp.viewTest.views.View;

public class SomeEntity {
    private Integer id;

    private String baseInfo;

    @JsonView(View.AuthenticatedUser.class)
    private String userInfo;

    @JsonView(View.Admin.class)
    private String secretInfo;

    public SomeEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }
}