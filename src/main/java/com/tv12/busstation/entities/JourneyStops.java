package com.tv12.busstation.entities;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Immutable
@Subselect("select * from journey_stops")
public class JourneyStops {
    @Id
    private Integer journeyId;
    private String city_name;
    private Date timestamp;
}
