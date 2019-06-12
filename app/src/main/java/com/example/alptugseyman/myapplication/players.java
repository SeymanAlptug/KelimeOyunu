package com.example.alptugseyman.myapplication;

public class players {

    private String playerId,playerName;
    private int playerLvl;

    public players(){

    }

    public String getPlayerId(){
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

    public int getPlayerLvl(){
        return playerLvl;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public players(String playerId,String playerName,int playerLvl){
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerLvl = playerLvl;
    }
}
