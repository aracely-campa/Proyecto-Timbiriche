package resources;

import enums.ImagesSourcers;

public class AvatarSelector {

    private String[] avatarPaths;

    public AvatarSelector() {
        this.avatarPaths = ImagesSourcers.getAvatarImages();
        // Asegúrate de que avatarPaths no es null ni está vacío
        if (avatarPaths == null || avatarPaths.length == 0) {
            throw new IllegalStateException("No avatar images available");
        }
    }

    public String getSelectedAvatarPath(String currentAvatarPath) {
        int index = getIndex(currentAvatarPath);
        return avatarPaths[index];
    }

  public String getPreviousAvatarPath(String currentAvatarPath) {
    int index = getIndex(currentAvatarPath);
    index = (index - 1 + avatarPaths.length) % avatarPaths.length;
    System.out.println("Prev index: " + index); // Agregar mensajes de depuración
    return avatarPaths[index];
}

public String getNextAvatarPath(String currentAvatarPath) {
    int index = getIndex(currentAvatarPath);
    index = (index + 1) % avatarPaths.length;
    System.out.println("Next index: " + index); // Agregar mensajes de depuración
    return avatarPaths[index];
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
