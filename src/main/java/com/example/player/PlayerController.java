package com.example.player;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.player.PlayerService;
import com.example.player.Player;
import java.util.*;

@RestController
public class PlayerController {
    PlayerService playerService = new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player players) {
        return playerService.addPlayer(players);
    }

    @GetMapping("/players/{playerId}")
    public Player playerById(@PathVariable("playerId") int playerId) {
        return playerService.playerById(playerId);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayerById(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return playerService.updatePlayerById(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayerById(@PathVariable("playerId") int playerId) {
        playerService.deletePlayerById(playerId);
    }

}
