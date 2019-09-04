package controller;

import model.ArgumentState;
import model.PowerPoint;

public class Main {


  public static void main(String[] args) throws Exception{
    var pptx = new PowerPoint();
    var commandInvoker = new CommandInvoker(pptx,args);
    commandInvoker.execute();

  }

  public static void help(){
    var argumentsStatesPrefix="Os prefixos de argumento string disponíveis são:\n";
    for (var argumentState: ArgumentState.values()) {
      argumentsStatesPrefix+=argumentState.name()+": \""+argumentState.getState()+"\" \n";
    }
    System.out.println(argumentsStatesPrefix);
  }

}
