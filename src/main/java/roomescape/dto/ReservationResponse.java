package roomescape.dto;

import roomescape.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationResponse(Long id, String name, LocalDate date, LocalTime time) {

    public static ReservationResponse from(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getName(),
                reservation.getDate(),
                reservation.getTime()
        );
    }
}
