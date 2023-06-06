package utils.cosmosdb;

import com.azure.cosmos.*;
import utils.ConfigFactory;

import java.util.Objects;

public class CosmosDBManager {
    private final CosmosAsyncClient client;
    private CosmosAsyncDatabase database;
    private static boolean isConnected;
    private CosmosDBManager(){
        var config = ConfigFactory.getConfig();
        Objects.requireNonNull(config.host(), "Please add database host URI");
        Objects.requireNonNull(config.accountKey(), "Please add database account key");

        client = new CosmosClientBuilder()
                .endpoint(config.host())
                .key(config.accountKey())
                .buildAsyncClient();
    }

    private static class SingletonHelper{
        private static final CosmosDBManager cosmosDbManager = new CosmosDBManager();
    }

    public static CosmosDBManager getOrCreateConnection(){
        isConnected = true;
        return SingletonHelper.cosmosDbManager;
    }

    public CosmosDBManager loadDataBase(String databaseName){
        database = client.getDatabase(databaseName);
        return this;
    }

    public CosmosAsyncContainer loadContainer(String containerName){
        return database.getContainer(containerName);
    }

    private void close(){
        try{
            client.close();
        }catch (CosmosException exp){
            // Todo logging
        }
    }

    public static void closeIfConnectionExists(){
        if(isConnected){
            SingletonHelper.cosmosDbManager.close();
            isConnected = false;
        }
    }
}
