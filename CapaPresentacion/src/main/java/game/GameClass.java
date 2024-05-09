package game;

import domain.game.Player;
import domain.graph.Node;
import events.BoardEvents;
import events.NodeEvents;
import events.PlayerEvents;
import interfaces.MatchObserver;
import javax.swing.JOptionPane;
import mvc.board.BoardView;
import mvc.game.GameComponent;
import mvc.node.NodeController;
import mvc.node.NodeView;
import mvc.player.PlayerView;

public class GameClass implements MatchObserver {

    public GameComponent gameComponent;
    private Node node;
    private Player player;

    public GameClass(Player player) {
        this.player = player;
        this.gameComponent = new GameComponent();
    }

    public Player[] getPlayersOnGame() {
        return this.gameComponent.getPlayersOnGame();
    }

    public BoardView getBoardView() {
        return gameComponent.getBoardComponent().getBoardView();

    }

    public PlayerView getPlayerView() {
        return gameComponent.getPlayerComponent().getPlayerView();
    }

    public NodeView getNodeView() {
        return gameComponent.getNodeComponent().getNodeView();
    }

    @Override
    public void eventOnNodeUpdate(NodeEvents evt) {
        if (NodeEvents.LEFT_CLICK_ON_NODE_EVENT.equals(evt)) {

        }
    }

    @Override
    public void eventOnBoardUpdate(BoardEvents evt) {

    }

    @Override
    public void eventOnPlayerUpdate(PlayerEvents evt) {
        if (PlayerEvents.LEFT_CLICK_ON_PLAYER_EVENT.equals(evt)) {
            JOptionPane.showMessageDialog(null, "Seleccionaste una linea ");

        }
    }
}
