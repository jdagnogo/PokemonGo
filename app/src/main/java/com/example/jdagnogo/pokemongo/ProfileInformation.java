package com.example.jdagnogo.pokemongo;

/**
 * Created by jdagnogo on 27/07/2016.
 */
public class ProfileInformation {

    private String speudo;

    private int battleAttack;

    private int battleDefend;

    private int battleTotalAttack;

    private int bigMagicark;

    private int nbEvolution;

    private int level;

    private int nbPokeballUse;

    private int nbPokemonCapture;

    private int nbPokestop;


    public ProfileInformation(String speudo, int battleAttack, int battleDefend, int battleTotalAttack, int bigMagicark, int nbEvolution, int level, int nbPokeballUse, int nbPokemonCapture, int nbPokestop) {
        this.speudo = speudo;
        this.battleAttack = battleAttack;
        this.battleDefend = battleDefend;
        this.battleTotalAttack = battleTotalAttack;
        this.bigMagicark = bigMagicark;
        this.nbEvolution = nbEvolution;
        this.level = level;
        this.nbPokeballUse = nbPokeballUse;
        this.nbPokemonCapture = nbPokemonCapture;
        this.nbPokestop = nbPokestop;
    }

    @Override
    public String toString() {
        return "ProfileInformation{" +
                "\n speudo='" + speudo + '\'' +
                ",\n battleAttack=" + battleAttack +
                ",\n battleDefend=" + battleDefend +
                ",\n battleTotalAttack=" + battleTotalAttack +
                ",\n bigMagicark=" + bigMagicark +
                ",\n nbEvolution=" + nbEvolution +
                ",\n level=" + level +
                ",\n nbPokeballUse=" + nbPokeballUse +
                ",\n nbPokemonCapture=" + nbPokemonCapture +
                ",\n nbPokestop=" + nbPokestop +
                '}';
    }

    public String getSpeudo() {
        return speudo;
    }

    public void setSpeudo(String speudo) {
        this.speudo = speudo;
    }

    public int getBattleAttack() {
        return battleAttack;
    }

    public void setBattleAttack(int battleAttack) {
        this.battleAttack = battleAttack;
    }

    public int getBattleDefend() {
        return battleDefend;
    }

    public void setBattleDefend(int battleDefend) {
        this.battleDefend = battleDefend;
    }

    public int getBattleTotalAttack() {
        return battleTotalAttack;
    }

    public void setBattleTotalAttack(int battleTotalAttack) {
        this.battleTotalAttack = battleTotalAttack;
    }

    public int getBigMagicark() {
        return bigMagicark;
    }

    public void setBigMagicark(int bigMagicark) {
        this.bigMagicark = bigMagicark;
    }

    public int getNbEvolution() {
        return nbEvolution;
    }

    public void setNbEvolution(int nbEvolution) {
        this.nbEvolution = nbEvolution;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNbPokeballUse() {
        return nbPokeballUse;
    }

    public void setNbPokeballUse(int nbPokeballUse) {
        this.nbPokeballUse = nbPokeballUse;
    }

    public int getNbPokemonCapture() {
        return nbPokemonCapture;
    }

    public void setNbPokemonCapture(int nbPokemonCapture) {
        this.nbPokemonCapture = nbPokemonCapture;
    }

    public int getNbPokestop() {
        return nbPokestop;
    }

    public void setNbPokestop(int nbPokestop) {
        this.nbPokestop = nbPokestop;
    }
}
