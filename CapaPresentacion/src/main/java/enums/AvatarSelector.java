package enums;

/**
 * AvatarSelector gestiona la selección de avatares de una lista predefinida,
 * permitiendo a los usuarios navegar hacia adelante y hacia atrás entre las
 * opciones.
 */
public class AvatarSelector {

    private String[] avatarPaths; // Array que contiene las rutas a las imágenes de avatares.
    private int currentAvatarIndex = 0; // Índice del avatar actualmente seleccionado.

    /**
     * Constructor de AvatarSelector que inicializa la lista de avatares y
     * asegura que haya avatares disponibles para seleccionar.
     */
    public AvatarSelector() {
        this.avatarPaths = ImagesSourcers.getAvatarImages(); // Obtiene las imágenes de avatares disponibles.

        // Asegúrate de que hay avatares disponibles para seleccionar.
        if (avatarPaths == null || avatarPaths.length == 0) {
            throw new IllegalStateException("No avatar images available");
        }
    }

    /**
     * Devuelve la ruta del avatar actualmente seleccionado.
     *
     * @return La ruta del archivo de la imagen del avatar seleccionado.
     */
    public String getSelectedAvatarPath() {
        return avatarPaths[currentAvatarIndex];
    }

    /**
     * Devuelve la ruta del avatar anterior en la lista, cambiando el índice
     * actualmente seleccionado.
     *
     * @return La ruta del archivo de la imagen del avatar previo.
     */
    public String getPreviousAvatarPath() {
        currentAvatarIndex = (currentAvatarIndex - 1 + avatarPaths.length) % avatarPaths.length;
        System.out.println("Prev index: " + currentAvatarIndex); // Mensaje de depuración para rastrear el índice.
        return avatarPaths[currentAvatarIndex];
    }

    /**
     * Devuelve la ruta del próximo avatar en la lista, cambiando el índice
     * actualmente seleccionado.
     *
     * @return La ruta del archivo de la imagen del próximo avatar.
     */
    public String getNextAvatarPath() {
        currentAvatarIndex = (currentAvatarIndex + 1) % avatarPaths.length;
        System.out.println("Next index: " + currentAvatarIndex); // Mensaje de depuración para rastrear el índice.
        return avatarPaths[currentAvatarIndex];
    }

    /**
     * Busca el índice de un avatar específico en la lista de avatares por su
     * ruta.
     *
     * @param currentAvatarPath La ruta del avatar para el cual se busca el
     * índice.
     * @return El índice del avatar, o el último índice si el avatar no se
     * encuentra.
     */
    private int getIndex(String currentAvatarPath) {
        if (currentAvatarPath != null) {
            for (int i = 0; i < avatarPaths.length; i++) {
                if (avatarPaths[i].equalsIgnoreCase(currentAvatarPath)) {
                    return i;
                }
            }
        }
        return avatarPaths.length - 1; // Retorna un índice neutral cuando no se encuentra.
    }
}
