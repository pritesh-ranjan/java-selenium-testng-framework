package utils.cosmosdb;

import com.azure.cosmos.*;


import java.util.Objects;

import static utils.FrameworkUtilities.LOGGER;
import static utils.FrameworkUtilities.getConfig;

public class CosmosDBManager {
    private static boolean isConnected;
    private final CosmosAsyncClient client;
    private CosmosAsyncDatabase database;

    private CosmosDBManager() {
        var config = getConfig();
        Objects.requireNonNull(config.host(), "Please add database host URI");
        Objects.requireNonNull(config.accountKey(), "Please add database account key");

        client = new CosmosClientBuilder()
                .endpoint(config.host())
                .key(config.accountKey())
                .buildAsyncClient();
    }

    public static CosmosDBManager getOrCreateConnection() {
        isConnected = true;
        return SingletonHelper.cosmosDbManager;
    }

    public static void closeIfConnectionExists() {
        if (isConnected) {
            SingletonHelper.cosmosDbManager.close();
            isConnected = false;
        }
    }

    public CosmosDBManager loadDataBase(String databaseName) {
        database = client.getDatabase(databaseName);
        return this;
    }

    public CosmosAsyncContainer loadContainer(String containerName) {
        return database.getContainer(containerName);
    }

    private void close() {
        try {
            client.close();
        } catch (CosmosException exp) {
            LOGGER.warn("error in closing cosmos db connection: {}", exp.getStackTrace());
        }
    }

    private static class SingletonHelper {
        private static final CosmosDBManager cosmosDbManager = new CosmosDBManager();
    }
}
