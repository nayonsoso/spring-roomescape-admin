package roomescape.service;

import org.springframework.stereotype.Service;
import roomescape.dto.ReservationTimeRequest;
import roomescape.dto.ReservationTimeResponse;
import roomescape.model.ReservationTime;
import roomescape.repository.ReservationTimeRepository;

import java.util.List;

@Service
public class ReservationTimeService {

    private final ReservationTimeRepository reservationTimeRepository;

    public ReservationTimeService(ReservationTimeRepository reservationTimeRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
    }

    public List<ReservationTimeResponse> getAllReservationTimes() {
        return reservationTimeRepository.findAll()
                .stream()
                .map(ReservationTimeResponse::from)
                .toList();
    }

    public ReservationTimeResponse addReservationTime(ReservationTimeRequest reservationTimeRequest) {
        ReservationTime reservationTime = ReservationTimeRequest.toReservationTime(reservationTimeRequest);
        ReservationTime savedReservationTime = reservationTimeRepository.save(reservationTime);
        return ReservationTimeResponse.from(savedReservationTime);
    }

    public void deleteReservationTimeById(Long id) {
        reservationTimeRepository.deleteById(id);
    }
}
