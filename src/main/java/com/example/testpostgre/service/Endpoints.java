package com.example.testpostgre.service;

import java.util.ArrayList;
import java.util.List;

public enum Endpoints {
    HOME("/"),
    LOGIN("/login"),
    LOGOUT("/logout"),
    USER_VIEW("/userInfo"),
    DRIVERS_GET("/drivers/get"),
    TRUCKS_GET("/trucks/get"),
    STATISTIC("/statistic"),
    SALARY_GET("/salary/get"),
    SALARY_DRIVER("/salaryDriver"),
    CREATE_DRIVER("/createDriver"),
    UPDATE_DRIVER("/updateDriver"),
    DESTIN_GET("/destinations/get"),
   ORDERS_GET("/orders/get"),
    TRUCKREPAIR_GET("/truckrepair/get"),

    ;

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    static public List<Endpoints> getEndpointForAllUsers() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(HOME);
        endpoints.add(LOGIN);
        endpoints.add(LOGOUT);
        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdminStuff() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(USER_VIEW);
        endpoints.add(DRIVERS_GET);
        endpoints.add(TRUCKS_GET);
        endpoints.add(STATISTIC);
        endpoints.add(SALARY_GET);
        endpoints.add(SALARY_DRIVER);
        endpoints.add(CREATE_DRIVER);
        endpoints.add(UPDATE_DRIVER);
        endpoints.add(DESTIN_GET);
        endpoints.add(ORDERS_GET);
        endpoints.add(TRUCKREPAIR_GET);

        return endpoints;
    }

}
