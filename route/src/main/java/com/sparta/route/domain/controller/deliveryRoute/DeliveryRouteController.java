package com.sparta.route.domain.controller.deliveryRoute;

import com.sparta.route.domain.dto.deliveryRoute.DeliveryRouteDto;
import com.sparta.route.domain.model.deliveryRoute.enums.DeliveryStatus;
import com.sparta.route.domain.service.deliveryRoute.DeliveryRouteService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/routes/delivery")
public class DeliveryRouteController {

    private final DeliveryRouteService deliveryRouteService;

    @GetMapping("/{deliveryId}")
    public ResponseEntity<List<DeliveryRouteDto>> getRoutesForDelivery(@PathVariable UUID deliveryId) {
        List<DeliveryRouteDto> routes = deliveryRouteService.getRoutesForDelivery(deliveryId);
        return ResponseEntity.ok(routes);
    }

    @PostMapping
    public ResponseEntity<Void> createDeliveryRoute(@RequestBody List<DeliveryRouteDto> routes, @RequestParam UUID deliveryId) {
        deliveryRouteService.createDeliveryRoute(deliveryId, routes);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{routeId}/status")
    public ResponseEntity<Void> updateRouteStatus(@PathVariable UUID routeId, @RequestBody DeliveryStatus newStatus) {
        deliveryRouteService.updateRouteStatus(routeId, newStatus);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable UUID routeId) {
        deliveryRouteService.deleteRoute(routeId);
        return ResponseEntity.ok().build();
    }
}
