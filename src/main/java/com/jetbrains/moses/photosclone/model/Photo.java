package com.jetbrains.moses.photosclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Photo {

    private String id;
    private String fileName;
    private String contentType;
    @JsonIgnore
    private byte[] data;

    public Photo() {

    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
