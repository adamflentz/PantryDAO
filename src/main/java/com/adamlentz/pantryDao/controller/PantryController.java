package com.adamlentz.pantryDao.controller;

import com.adamlentz.pantryDao.clients.AuthClient;
import com.adamlentz.pantryDao.entities.Pantry;
import com.adamlentz.pantryDao.payloads.CreatePantryRequest;
import com.adamlentz.pantryDao.repositories.PantryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController(value = "pantryDao")
@RequestMapping("/pantry")
public class PantryController {

    private PantryRepository pantryRepository;
    private AuthClient authClient;

    @Autowired
    public PantryController(final PantryRepository pantryRepository, final AuthClient authClient) {
        this.pantryRepository = pantryRepository;
        this.authClient = authClient;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Pantry> getAllPantries() {
        // This returns a JSON or XML with the users
        return pantryRepository.findAll();
    }

    @GetMapping(path= "/mypantries")
    public @ResponseBody
    Iterable<Pantry> getMyPantries(@RequestHeader("Authorization") String bearerToken) {
        log.info(bearerToken);
        String username = authClient.retrieveUserDetails(bearerToken).getUsername();
        return pantryRepository.findByUserName(username);
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Pantry createPantry(@RequestHeader("Authorization") String bearerToken, @RequestBody CreatePantryRequest pantryRequest) {
        Pantry pantry = new Pantry();
        pantry.setUserName(authClient.retrieveUserDetails(bearerToken).getUsername());
        pantry.setPantryName(pantryRequest.getPantryName());
        if (pantryRepository.findByUserName(pantryRequest.getUserName()).size() == 0) {
            pantry.setPrimaryPantry(true);
        } else {
            pantry.setPrimaryPantry(pantryRequest.getIsPrimary() == null ? false : pantryRequest.getIsPrimary());
        }
        return pantryRepository.save(pantry);
    }
}