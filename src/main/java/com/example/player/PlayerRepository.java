// Write your code here
package com.example.player;

import com.example.player.Player;

import java.util.*;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player addPlayer(Player players);

    Player playerById(int playerId);

    Player updatePlayerById(int playerId, Player player);

    void deletePlayerById(int playerId);

}
