package controller;

import model.ICommand;
import model.PowerPoint;
import service.ArgumentHandler;

public class CommandInvoker {
  final private String args[];
  final private PowerPoint pptx;

  public CommandInvoker(PowerPoint pptx,String... args){
    this.pptx = pptx;
    this.args = args;
  }

  public void execute(){
    for (String arg:args) {
      ICommand command = ArgumentHandler.discriminateArgumentStateType(arg,this.pptx);
      command.execute();
    }
    pptx.saveFile();
  }
}
