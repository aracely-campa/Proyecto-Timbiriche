/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import enums.ImagesSourcers;

/**
 *
 * @author arace
 */
public class AvatarSelector {
   private String[] avatarPaths;

    public AvatarSelector() {
        this.avatarPaths = ImagesSourcers.getAvatarImages();
    }

    public String getSelectedAvatarPath(String currentAvatarPath) {
        int index = getIndex(currentAvatarPath);
        return avatarPaths[index];
    }

    public String getPreviousAvatarPath(String currentAvatarPath) {
        int index = getIndex(currentAvatarPath);
        index = (index - 1 + avatarPaths.length) % avatarPaths.length;
        return avatarPaths[index];
    }

    public String getNextAvatarPath(String currentAvatarPath) {
        int index = getIndex(currentAvatarPath);
        index = (index + 1) % avatarPaths.length;
        return avatarPaths[index];
    }

    private int getIndex(String currentAvatarPath) {
        if (currentAvatarPath != null) {
            for (int i = 0; i < avatarPaths.length; i++) {
                if (avatarPaths[i].equals(currentAvatarPath)) {
                    return i;
                }
            }
        }
        return 0;
    }
}
