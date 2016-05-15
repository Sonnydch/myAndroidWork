package com.sonny.telbrochure.bean;

import com.yokeyword.indexablelistview.IndexEntity;

import java.io.Serializable;

/**
 * Created by sonny on 16-5-15.
 */
public class Contactor extends IndexEntity implements Serializable{
    private String mobile;
    private String avartar;


    public Contactor(String name,String mobile){
        super(name);
        this.mobile = mobile;
    }
    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
