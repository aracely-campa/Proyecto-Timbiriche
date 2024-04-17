/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.player;



/**
 *
 * @author arace
 */
public class PlayerComponent {

    private PlayerController playerController;
    private Player player;
    private String name;
    private Integer id;
    private boolean turnoJugador;

    public PlayerComponent(PlayerController playerController, Player player, String name, int id, boolean turnoJugador) {
        this.playerController = playerController;
        this.player = player;
        this.name = name;
        this.id = id;
        this.turnoJugador = turnoJugador;
    }

    public Player getPlayer() {
        return this.playerController.getPlayer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTurnoJugador() {
        return turnoJugador;
    }

    public void setTurnoJugador(boolean turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    @Override
    public String toString() {
        return "PlayerComponent{" + "playerController=" + playerController + ", player=" + player + ", name=" + name + ", id=" + id + ", turnoJugador=" + turnoJugador + '}';
    }

    
}
