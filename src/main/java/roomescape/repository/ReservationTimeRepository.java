package roomescape.repository;

import roomescape.model.ReservationTime;

import java.util.List;

public interface ReservationTimeRepository {

    List<ReservationTime> findAll();

    ReservationTime findById(Long id);

    ReservationTime save(ReservationTime reservationTime);

    void deleteById(Long id);
}
