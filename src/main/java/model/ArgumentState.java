package model;

public enum ArgumentState {
  InputFile("-I:"),
  OutputFile("-O:"),
  InOutFile("-IO:"),
  FontSize("-FS:"),
  FontFamily("-FF:"),
  FontColor("-FC:"),
  SlideNumber("-SL:"),
  ShapeNumber("-SP:"),
  ShapeText("-TX:");

  public String state;

  ArgumentState(String state){
    this.state = state;
  }

  public String getState() {
    return this.state;
  }

  public static ArgumentState stateByPrefix(final String arg) {
    for (ArgumentState argumentState: ArgumentState.values()) {
      if(arg.contains(argumentState.getState())){
        return argumentState;
      }
    }
    return null;
  }
}
