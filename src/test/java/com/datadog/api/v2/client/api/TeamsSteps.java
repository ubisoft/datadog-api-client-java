package com.datadog.api.v2.client.api;

import io.cucumber.java.en.Given;
import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.api.TeamsApi;
import com.datadog.api.v2.client.model.TeamCreateAttributes;
import com.datadog.api.v2.client.model.TeamCreateData;
import com.datadog.api.v2.client.model.TeamCreateRequest;
import com.datadog.api.v2.client.model.TeamResponse;
import com.datadog.api.World;

public class TeamsSteps {

    private World world;

    public TeamsSteps(World world) {
        this.world = world;
    }

    @Given("there is a valid \"team\" in the system")
    public void thereIsAValidTeamInTheSystem() throws com.datadog.api.v2.client.ApiException {
        TeamCreateAttributes tca = new TeamCreateAttributes().name(world.getUniqueEntityName());
        TeamCreateData tcd = new TeamCreateData().attributes(tca);
        TeamCreateRequest tcr = new TeamCreateRequest().data(tcd);
        TeamsApi teamsAPI = new TeamsApi((ApiClient) world.client);
        ((ApiClient) world.client).setUnstableOperationEnabled("createTeam", true);
        TeamResponse tr = teamsAPI.createTeam().body(tcr).execute();
        ((ApiClient) world.client).setUnstableOperationEnabled("createTeam", false);

        world.context.put("team", tr);

        Undo.createTeam(teamsAPI, (Object) tr);
    }

}
