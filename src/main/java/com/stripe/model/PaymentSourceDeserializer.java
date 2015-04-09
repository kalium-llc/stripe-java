package com.stripe.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class PaymentSourceDeserializer implements JsonDeserializer<PaymentSource> {
  private static final String SOURCE_OBJECT_PROP = "object";

  public PaymentSource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException {

    String sourceObject = json.getAsJsonObject().getAsJsonPrimitive(SOURCE_OBJECT_PROP).getAsString();
    Class<?> clazz;
    if (sourceObject.equals("bitcoin_receiver")) {
      clazz = BitcoinReceiver.class;
    } else if (sourceObject.equals("card")) {
      clazz = Card.class;
    } else {
      clazz = PaymentSource.class;
    }

    return (PaymentSource) context.deserialize(json, clazz);
  }
}
