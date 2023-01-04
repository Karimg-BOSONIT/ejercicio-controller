package org.example.ejerciciocontroller;

import java.util.List;

public class ControllerObject {

    private List<String> paths;
    private List<Query> querys;
    private List<Header> headers;
    private String urlOrigen;

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public List<Query> getQuerys() {
        return querys;
    }

    public void setQuerys(List<Query> querys) {
        this.querys = querys;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getUrlOrigen() {
        return urlOrigen;
    }

    public void setUrlOrigen(String urlOrigen) {
        this.urlOrigen = urlOrigen;
    }

}
