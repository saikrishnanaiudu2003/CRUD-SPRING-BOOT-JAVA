// Write your code here
package com.example.player;

import com.example.player.Player;

import java.util.*;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player addPlayer(Player players);

    Player playerById(int playerId);

    Player updatePlayer(int playerId, Player players);

    void deletePlayer(int playerId);

}