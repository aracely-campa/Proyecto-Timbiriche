package resources;

import enums.ImagesSourcers;

public class AvatarSelector {

    private String[] avatarPaths;
    private int currentAvatarIndex = 0;
    public AvatarSelector() {
        this.avatarPaths = ImagesSourcers.getAvatarImages();
        // Asegúrate de que avatarPaths no es null ni está vacío
        if (avatarPaths == null || avatarPaths.length == 0) {
            throw new IllegalStateException("No avatar images available");
        }
    }

    public String getSelectedAvatarPath() {
        return avatarPaths[currentAvatarIndex];
    }

    public String getPreviousAvatarPath() {
       
        currentAvatarIndex = (currentAvatarIndex - 1 + avatarPaths.length) % avatarPaths.length;
        System.out.println("Prev index: " + currentAvatarIndex); // Agregar mensajes de depuración
        return avatarPaths[currentAvatarIndex];
    }

    public String getNextAvatarPath() {
        currentAvatarIndex = (currentAvatarIndex + 1) % avatarPaths.length;
        System.out.println("Next index: " + currentAvatarIndex); // Agregar mensajes de depuración
        return avatarPaths[currentAvatarIndex];
    }

    private int getIndex(String currentAvatarPath) {
        if (currentAvatarPath != null) {
            for (int i = 0; i < avatarPaths.length; i++) {
                if (avatarPaths[i].equalsIgnoreCase(currentAvatarPath)) {
                    return i;
                }
            }
        }
        // Retornar un índice neutral cuando no se encuentra, como el último índice
        return avatarPaths.length - 1;
    }
}
