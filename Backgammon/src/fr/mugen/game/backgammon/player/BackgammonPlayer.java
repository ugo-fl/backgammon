package fr.mugen.game.backgammon.player;

import fr.mugen.game.backgammon.BackgammonBoard;
import fr.mugen.game.backgammon.BackgammonColumn.Color;
import fr.mugen.game.backgammon.Dice;
import fr.mugen.game.backgammon.display.JavaFXDisplay;
import fr.mugen.game.framework.Board;
import fr.mugen.game.framework.Controls;
import fr.mugen.game.framework.Display;
import fr.mugen.game.framework.Player;
import fr.mugen.game.framework.Rules;

public abstract class BackgammonPlayer extends Player {

  protected final Color color;

  public BackgammonPlayer(final Controls controls, final Color color) {
    super(controls);
    this.color = color;
  }

  @Override
  public void play(final Board board, final Rules rules, final Display display) {
    final Dice dice = ((BackgammonBoard) board).getDice();

    if (!dice.keepPlaying()) {
      dice.roll();
      ((JavaFXDisplay) display).playRollingDiceSound();
    }

    _play(board, rules, display);
  }

  protected abstract void _play(final Board board, final Rules rules, final Display display);

  public Color getColor() {
    return this.color;
  }

}
