package com.epopovic.points;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "route"
})
public class RouteResponse {
    @JsonProperty("route")
    private RouteObject route;

    public RouteResponse() {}

    @JsonProperty("route")
    public RouteObject getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(RouteObject route) {
        this.route = route;
    }
}
