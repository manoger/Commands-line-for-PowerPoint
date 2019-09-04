package service;

import java.awt.*;
import java.util.HashMap;

public class ApplicationColorUtil {

  public static HashMap<String,Color> colorsByName = new HashMap<>();
  public static void initApplicationColorMap(){
    colorsByName.put("azul", new Color(0, 99, 162));
    colorsByName.put("laranja", new Color(203, 99, 79));
    colorsByName.put("cinza", new Color(166, 166, 166));
  }

  public static Color getColorByName(String colorName){
    colorName = colorName.toLowerCase();
    initApplicationColorMap();
    Color applicationColor;
    applicationColor = Color.getColor(colorName);
    if(applicationColor == null) {
      applicationColor = colorsByName.get(colorName);
    }
    return applicationColor;
  }
}
