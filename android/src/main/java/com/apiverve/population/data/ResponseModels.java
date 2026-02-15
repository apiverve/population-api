// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     PopulationDataData data = Converter.fromJsonString(jsonString);

package com.apiverve.population.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static PopulationDataData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(PopulationDataData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(PopulationDataData.class);
        writer = mapper.writerFor(PopulationDataData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// PopulationDataData.java

package com.apiverve.population.data;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class PopulationDataData {
    private String country;
    private String countryISO3;
    private String countryName;
    private long year;
    private long population;
    private String populationFormatted;
    private double growthRate;
    private double density;
    private String densityUnit;
    private double urbanPercent;
    private double ruralPercent;
    private long urbanPopulation;
    private long ruralPopulation;
    private double lifeExpectancy;
    private OffsetDateTime lastUpdated;

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("countryISO3")
    public String getCountryISO3() { return countryISO3; }
    @JsonProperty("countryISO3")
    public void setCountryISO3(String value) { this.countryISO3 = value; }

    @JsonProperty("countryName")
    public String getCountryName() { return countryName; }
    @JsonProperty("countryName")
    public void setCountryName(String value) { this.countryName = value; }

    @JsonProperty("year")
    public long getYear() { return year; }
    @JsonProperty("year")
    public void setYear(long value) { this.year = value; }

    @JsonProperty("population")
    public long getPopulation() { return population; }
    @JsonProperty("population")
    public void setPopulation(long value) { this.population = value; }

    @JsonProperty("populationFormatted")
    public String getPopulationFormatted() { return populationFormatted; }
    @JsonProperty("populationFormatted")
    public void setPopulationFormatted(String value) { this.populationFormatted = value; }

    @JsonProperty("growthRate")
    public double getGrowthRate() { return growthRate; }
    @JsonProperty("growthRate")
    public void setGrowthRate(double value) { this.growthRate = value; }

    @JsonProperty("density")
    public double getDensity() { return density; }
    @JsonProperty("density")
    public void setDensity(double value) { this.density = value; }

    @JsonProperty("densityUnit")
    public String getDensityUnit() { return densityUnit; }
    @JsonProperty("densityUnit")
    public void setDensityUnit(String value) { this.densityUnit = value; }

    @JsonProperty("urbanPercent")
    public double getUrbanPercent() { return urbanPercent; }
    @JsonProperty("urbanPercent")
    public void setUrbanPercent(double value) { this.urbanPercent = value; }

    @JsonProperty("ruralPercent")
    public double getRuralPercent() { return ruralPercent; }
    @JsonProperty("ruralPercent")
    public void setRuralPercent(double value) { this.ruralPercent = value; }

    @JsonProperty("urbanPopulation")
    public long getUrbanPopulation() { return urbanPopulation; }
    @JsonProperty("urbanPopulation")
    public void setUrbanPopulation(long value) { this.urbanPopulation = value; }

    @JsonProperty("ruralPopulation")
    public long getRuralPopulation() { return ruralPopulation; }
    @JsonProperty("ruralPopulation")
    public void setRuralPopulation(long value) { this.ruralPopulation = value; }

    @JsonProperty("lifeExpectancy")
    public double getLifeExpectancy() { return lifeExpectancy; }
    @JsonProperty("lifeExpectancy")
    public void setLifeExpectancy(double value) { this.lifeExpectancy = value; }

    @JsonProperty("lastUpdated")
    public OffsetDateTime getLastUpdated() { return lastUpdated; }
    @JsonProperty("lastUpdated")
    public void setLastUpdated(OffsetDateTime value) { this.lastUpdated = value; }
}