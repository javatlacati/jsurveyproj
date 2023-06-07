package org.javapro.entities;

import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerDataTest {

    @Test
    void parsingOfDate() throws Exception {
        AnswerData answerData;
        try (Jsonb jsonb = JsonbBuilder.create()) {
            answerData = jsonb.fromJson("{\n" +
                                        "  \"theDate\": \"06/04/2023\",\n" +
                                        "  \"answerIdx\": null,\n" +
                                        "  \"answer\": null\n" +
                                        "}", AnswerData.class);
        }
        assertEquals(new AnswerData(LocalDate.of(2023, Month.APRIL, 6), null, null), answerData);

    }
}
