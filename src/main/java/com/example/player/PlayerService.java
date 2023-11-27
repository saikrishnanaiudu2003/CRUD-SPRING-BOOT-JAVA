package com.example.player;

import com.example.player.Player;
import com.example.player.PlayerRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    int uniqueId = 12;

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> playerCollection = team.values();
        ArrayList<Player> allPlayers = new ArrayList<>(playerCollection);
        return allPlayers;
    }

    @Override
    public Player addPlayer(Player players) {
        players.setId(uniqueId);
        team.put(uniqueId, players);
        uniqueId += 1;
        return players;
    }

    @Override
    public Player playerById(int playerId) {
        Player existingPlayer = team.get(playerId);
        if (existingPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existingPlayer;
    }

    @Override

    public Player updatePlayer(int playerId, Player players) {
        Player existingPlayer = team.get(playerId);
        if (existingPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (existingPlayer != null) {
            existingPlayer.setPlayerName(players.getPlayerName());
        }
        if (existingPlayer != null) {
            existingPlayer.setJerseyNumber(players.getJerseyNumber());
        }

        if (existingPlayer != null) {
            existingPlayer.setRole(players.getRole());
        }

        return existingPlayer;
    }

    @Override
    public void deletePlayer(int playerId) {
        Player user = team.get(playerId);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
