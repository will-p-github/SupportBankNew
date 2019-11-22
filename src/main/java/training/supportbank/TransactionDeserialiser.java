package training.supportbank;

import com.google.gson.*;

import java.lang.reflect.Type;

public class TransactionDeserialiser implements JsonDeserializer<Transaction> {

    @Override
    public Transaction deserialize(JsonElement json, Type type,
                                   JsonDeserializationContext context) throws JsonParseException {

        JsonArray jArray = (JsonArray) json;
        String[] transactionData = new String[jArray.size()];

        for (int i = 0; i < jArray.size(); i++) {
            transactionData[i] = jArray.get(i).getAsString();
        }

        return FileHandler.processDataCreateTransaction(transactionData);
    }
}