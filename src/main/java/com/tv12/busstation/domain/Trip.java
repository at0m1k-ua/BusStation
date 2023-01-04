package com.tv12.busstation.domain;

import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Stop;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trip {
    private Journey journey;
    private Stop stopFrom;
    private Timestamp timestampFrom;
    private Stop stopTo;
    private Timestamp timestampTo;
    private int price;
}
