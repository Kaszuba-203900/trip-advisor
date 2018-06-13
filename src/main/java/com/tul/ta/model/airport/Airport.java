package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@EqualsAndHashCode()
@Data
@Table(name = "airports")
public class Airport {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;*/

    @Id
    @JsonProperty(value = "AirportCode")
    @Column(name = "airport_code")
    public String airportCode;
    @JsonProperty(value = "CityCode")
    @Column(name = "city_code")
    public String cityCode;
    @JsonProperty(value = "CountryCode")
    @Column(name = "country_code")
    public String countryCode;
    @JsonProperty(value = "LocationType")
    @Column(name = "location_type")
    public String locationType;
    @JsonProperty(value = "UtcOffset")
    @Column(name = "utc_offset")
    public Integer utcOffset;
    @JsonProperty(value = "TimeZoneId")
    @Column(name = "time_zone_id")
    public String timeZoneId;

    @Builder
    public Airport(String airportCode, String cityCode, String countryCode, String locationType, Integer utcOffset, String timeZoneId) {
        this.airportCode = airportCode;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.locationType = locationType;
        this.utcOffset = utcOffset;
        this.timeZoneId = timeZoneId;
    }

    @Tolerate
    public Airport() {

    }
}
