package enums;


/**
 * La clase ImagesSourcers centraliza el acceso a las rutas de archivos de imágenes usadas en la aplicación.
 * Esto facilita la gestión de las imágenes, ya que cualquier cambio en las rutas solo necesita actualizarse aquí.
 * @author arace
 */
public class ImagesSourcers {

    // Rutas a las imágenes de avatares.
    private static final String avatarBlue = "src/main/resources/avatar/avatarBlue.png";
    private static final String avatarRed = "src/main/resources/avatar/avatarRed.png";
    private static final String avatarGreen = "src/main/resources/avatar/avatarGreen.png";
    private static final String avatarYellow = "src/main/resources/avatar/avatarYellow.png";

    // Rutas a las imágenes de formularios de la interfaz gráfica.
    private static final String imgFrmLobby = "src/main/resources/desingFrm/lobbyT.png";
    private static final String imgFrmWelcome = "src/main/resources/desingFrm/frmWelcome.png";
    private static final String imgFrmJoinGame = "src/main/resources/desingFrm/frmJoinGame.png";
    private static final String imgFrmCreateGame = "src/main/resources/desingFrm/frmCreateGame.png";
    private static final String imgFrmPersonalization = "src/main/resources/desingFrm/frmPersonalization.png";
    private static final String imgFrmBoardGame = "src/main/resources/desingFrm/frmBoardGame.png";

    // Ruta a la imagen de un botón específico.
    private static final String imgBtnTwoPlayers = "src/main/resources/botones/btntwoplayers.png";

    // Constructor vacío: no es necesario inicializar nada en este caso.
    public ImagesSourcers() {
    }

    // Métodos estáticos para obtener las rutas de las imágenes de avatares.
    public static String[] getAvatarImages() {
        return new String[]{avatarBlue, avatarRed, avatarGreen, avatarYellow};
    }

    // Métodos estáticos para obtener las rutas de las imágenes de los formularios.
    public static String[] getFormImages() {
        return new String[]{imgFrmLobby, imgFrmWelcome, imgFrmJoinGame, imgFrmCreateGame, imgFrmPersonalization, imgFrmBoardGame};
    }

    // Método estático para obtener la ruta de la imagen del botón de dos jugadores.
    public static String[] getBtnImages() {
        return new String[]{imgBtnTwoPlayers};
    }

    // Métodos estáticos individuales para cada imagen, proporcionan acceso directo a cada recurso.
    public static String getAvatarBlue() { return avatarBlue; }
    public static String getAvatarRed() { return avatarRed; }
    public static String getAvatarGreen() { return avatarGreen; }
    public static String getAvatarYellow() { return avatarYellow; }
    public static String getImgFrmLobby() { return imgFrmLobby; }
    public static String getImgFrmWelcome() { return imgFrmWelcome; }
    public static String getImgFrmJoinGame() { return imgFrmJoinGame; }
    public static String getImgFrmCreateGame() { return imgFrmCreateGame; }
    public static String getImgFrmPersonalization() { return imgFrmPersonalization; }
    public static String getImgBtnTwoPlayers() { return imgBtnTwoPlayers; }
    public static String getImgFrmBoardGame() { return imgFrmBoardGame; }
}
