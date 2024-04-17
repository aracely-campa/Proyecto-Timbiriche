
package domain.player;



/**
 * 
 * @author arace
 */
public class main {

    public static void main(String[] args) {
        PlayerManager playerManager = PlayerManager.getInstance();

        
        PlayerController playerController = PlayerController.get();

       
        Player player1 = playerController.createPlayer("Player 1");
        Player player2 = playerController.createPlayer("Player 2");
        Player player3 = playerController.createPlayer("Player 3");
        Player player4 = playerController.createPlayer("Player 4");

        
        playerManager.createPlayer("Player 1", playerController, player1, 1, true);
        playerManager.createPlayer("Player 2", playerController, player2, 2, false);
        playerManager.createPlayer("Player 3", playerController, player3, 3, false);
        playerManager.createPlayer("Player 4", playerController, player4, 4, false);
    
}
}
