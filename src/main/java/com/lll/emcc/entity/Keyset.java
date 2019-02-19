package com.lll.emcc.entity;

import java.io.Serializable;

public class Keyset implements Serializable {
    private Integer keysetId;
    private String engKey;
    private String chaKey;
    private String keyType;
    private String keyLevel;

    public Integer getKeysetId() {
        return keysetId;
    }

    public void setKeysetId(Integer keysetId) {
        this.keysetId = keysetId;
    }

    public String getEngKey() {
        return engKey;
    }

    public void setEngKey(String engKey) {
        this.engKey = engKey;
    }

    public String getChaKey() {
        return chaKey;
    }

    public void setChaKey(String chaKey) {
        this.chaKey = chaKey;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyLevel() {
        return keyLevel;
    }

    public void setKeyLevel(String keyLevel) {
        this.keyLevel = keyLevel;
    }

    @Override
    public String toString() {
        return "Keyset{" +
                "keysetId=" + keysetId +
                ", engKey='" + engKey + '\'' +
                ", chaKey='" + chaKey + '\'' +
                ", keyType='" + keyType + '\'' +
                ", keyLevel='" + keyLevel + '\'' +
                '}';
    }
}
