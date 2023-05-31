package org.javapro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.smallrye.graphql.api.Union;
import org.javapro.deserializer.QuestionDeserializer;

@Union
@JsonDeserialize(using = QuestionDeserializer.class)
public interface ATypeOfQuestion {
}
