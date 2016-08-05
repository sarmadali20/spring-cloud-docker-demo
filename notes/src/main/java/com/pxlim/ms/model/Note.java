package com.pxlim.ms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Note implements Serializable {

    @JsonProperty("id")
    private Integer nodeId;
    @JsonProperty("title")
    private String title;

    public Note() {
        this.nodeId = 0;
        this.title = "";
    }

    public Note(Integer id, String title) {
        this.nodeId = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer id) {
        this.nodeId = id;
    }
}
