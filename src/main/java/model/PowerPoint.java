package model;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PowerPoint {
  public String inputPowerPointFilePath,outputPowerPointFilePath, fontFamily, text;
  public Integer slideNumber, rgb,shapeNumber;
  public Double fontSize;

  private XSLFSlide mySlide;
  private XMLSlideShow currentSlideShow;
  public void changePowerPointFile(){
    try {
      var currentFile = new FileInputStream(inputPowerPointFilePath);
      currentSlideShow = new XMLSlideShow(currentFile);
      var defaultMaster = currentSlideShow.getSlides();
      mySlide = defaultMaster.get(slideNumber);
      System.out.println("SlideShow modificado");
    }catch (Exception ex){

    }
  }
  public void editSlideText(){
    var textShape = ((XSLFTextShape) mySlide.getShapes().get(shapeNumber));
    var textRun = textShape.setText(text);
    textRun.setFontColor(new Color(rgb));
    textRun.setFontFamily(fontFamily);
    textRun.setFontSize(fontSize);
    System.out.println("Slide editado");
  }
  public void saveFile(){
    try {
      var out = new FileOutputStream(outputPowerPointFilePath);
      currentSlideShow.write(out);
      out.close();
    }catch (Exception ex){

    }
  }
  public void doNothingTest(){
    System.out.println("...");
  }

}
