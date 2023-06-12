package utils.cosmosdb;

import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.util.CosmosPagedFlux;

public abstract class AbstractCosmosContainer {
    protected CosmosAsyncContainer container;
    protected String containerName;

    protected AbstractCosmosContainer(String databaseName, String containerName) {
        container = CosmosDBManager
                .getOrCreateConnection()
                .loadDataBase(databaseName)
                .loadContainer(containerName);
        this.containerName = containerName;
    }

    public <T> CosmosPagedFlux<T> getResultsFromQuery(String query, Class<T> pojo) {
        return container.queryItems(query, pojo);
    }
}
