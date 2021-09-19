package ar.edu.unq.solotravel.backend.api.controllers;

import ar.edu.unq.solotravel.backend.api.exceptions.NoSuchElementException;
import ar.edu.unq.solotravel.backend.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/favorites")
    public ResponseEntity getUserFavorites(@PathVariable Integer userId) throws NoSuchElementException {
        return userService.getUserFavorites(userId);
    }

    @PutMapping("/{userId}/favorites/{tripId}")
    public ResponseEntity addTripToUserFavorites(@PathVariable Integer userId, @PathVariable Integer tripId) throws NoSuchElementException {
        return userService.addTripToUserFavorites(userId, tripId);
    }

    @DeleteMapping("/{userId}/favorites/{tripId}")
    public ResponseEntity removeTripFromUserFavorites(@PathVariable Integer userId, @PathVariable Integer tripId) throws NoSuchElementException{
        return userService.removeTripFromUserFavorites(userId, tripId);
    }
}
