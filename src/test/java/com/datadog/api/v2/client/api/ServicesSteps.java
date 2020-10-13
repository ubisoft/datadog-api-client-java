package com.datadog.api.v2.client.api;

import com.datadog.api.v2.client.model.ServiceCreateData;
import com.datadog.api.v2.client.model.ServiceResponse;

import io.cucumber.java.en.Given;
import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.api.ServicesApi;
import com.datadog.api.v2.client.model.ServiceCreateAttributes;
import com.datadog.api.v2.client.model.ServiceCreateRequest;
import com.datadog.api.World;

public class ServicesSteps {

    private World world;

    public ServicesSteps(World world) {
        this.world = world;
    }

    @Given("there is a valid \"service\" in the system")
    public void thereIsAValidServiceInTheSystem() throws com.datadog.api.v2.client.ApiException {
        ServiceCreateAttributes tca = new ServiceCreateAttributes().name(world.getUniqueEntityName());
        ServiceCreateData tcd = new ServiceCreateData().attributes(tca);
        ServiceCreateRequest tcr = new ServiceCreateRequest().data(tcd);
        ServicesApi servicesAPI = new ServicesApi((ApiClient) world.client);
        ((ApiClient) world.client).setUnstableOperationEnabled("createService", true);
        ServiceResponse tr = servicesAPI.createService().body(tcr).execute();
        ((ApiClient) world.client).setUnstableOperationEnabled("createService", false);

        world.context.put("service", tr);

        Undo.createService(servicesAPI, (Object) tr);
    }

}
