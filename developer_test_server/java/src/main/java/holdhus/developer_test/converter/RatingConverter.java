package holdhus.developer_test.converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import holdhus.developer_test.entity.Rating;

/**
 * Class used by JPA and Jackson for converting between Rating enums
 * and Strings.
 */
@Converter
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getStringValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbEnumString) {
        return Rating.fromStringValue(dbEnumString);
    }

    public static final class JsonSerializer extends StdSerializer<Rating> {
        private static final long serialVersionUID = 1;
        public JsonSerializer() {
            super(Rating.class);
        }
        @Override
        public void serialize(Rating value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.getStringValue());
        }
    }

    public static final class JsonDeserializer extends StdDeserializer<Rating> {
        private static final long serialVersionUID = 1;
        public JsonDeserializer() {
            super(Rating.class);
        }
        @Override
        public Rating deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return Rating.fromStringValue(p.getValueAsString());
        }
    }
}
