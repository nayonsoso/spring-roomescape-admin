package roomescape.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roomescape.dto.ReservationRequest;
import roomescape.dto.ReservationResponse;
import roomescape.model.Reservation;
import roomescape.repository.ReservationRepository;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getReservations() {
        List<ReservationResponse> list = reservationRepository.findAll()
                .stream()
                .map(ReservationResponse::from)
                .toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> addReservations(@RequestBody ReservationRequest reservationRequest) {
        Reservation reservation = ReservationRequest.from(reservationRequest);
        Reservation savedReservation = reservationRepository.save(reservation);
        ReservationResponse reservationResponse = ReservationResponse.from(savedReservation);

        return ResponseEntity.ok(reservationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);

        return ResponseEntity.ok()
                .build();
    }
}
