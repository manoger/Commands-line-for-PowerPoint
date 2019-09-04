package service;

import model.ICommand;
import model.ArgumentState;
import model.PowerPoint;

public class ArgumentHandler {

  public static ICommand discriminateArgumentStateType(final String argument, final PowerPoint pptx) {
    ICommand command = pptx::doNothingTest;
    final String argumentWithoutPrefix;
    var state = ArgumentState.stateByPrefix(argument);
    if (state == null) {
      //CustomException
    }
    argumentWithoutPrefix = argument.replace(state.getState(), "");
    switch (state) {
      case InputFile:
        pptx.inputPowerPointFilePath =argumentWithoutPrefix;
        break;
      case OutputFile:
        pptx.outputPowerPointFilePath = argumentWithoutPrefix;
        break;
      case InOutFile:
        pptx.inputPowerPointFilePath=argumentWithoutPrefix;
        pptx.outputPowerPointFilePath=argumentWithoutPrefix;
        break;
      case FontSize:
        pptx.fontSize =Double.parseDouble(argumentWithoutPrefix);
        break;
      case FontFamily:
        pptx.fontFamily = argumentWithoutPrefix;
        break;
      case FontColor:
        var foundColor = ApplicationColorUtil.getColorByName(argumentWithoutPrefix);
        pptx.rgb = foundColor.getRGB();
        break;
      case SlideNumber:
        pptx.slideNumber = Integer.parseInt(argumentWithoutPrefix)-1;
        command = pptx::changePowerPointFile;
        break;
      case ShapeNumber:
        pptx.shapeNumber = Integer.parseInt(argumentWithoutPrefix)-1;
        break;
      case ShapeText:
        pptx.text = argumentWithoutPrefix;
        command = pptx::editSlideText;
        break;
    }
    return command;
  }
}
