package Controller;

import Model.Hero.Hero;
import Model.MazeGenerator.Maze;
import Music.SoundsPlay;
import View.BattleView;
import View.GameView;
import View.Intro;
import View.Menus;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * This class is used to control the input from the user.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class GameManager {

    /**
     * The hero object.
     */
    private static Hero myHero;

    /**
     * The GameView object.
     */
    private static GameView myGameView;

    /**
     * The SaveCurrentGame object.
     */
    private static SaveCurrentState mySaveCurrentState;

    /**
     * The SaveManger object.
     */
    private static SaveManager mySaveManager;

    /**
     * The InputControls object.
     */
    private static InputControls myInputControls;
    
    /**
     * The Maze object.
     */
    private static Maze myMaze;

    /**
     * This is our constructor.
     *
     * @param theGameView is the GameView object.
     */
    public static void setGameView(final GameView theGameView) {
        myGameView = theGameView;
    }

    /**
     * This method is used to get the GameView object.
     *
     * @return the GameView object.
     */
    public static GameView getGameView() {
        return myGameView;
    }

    /**
     * This method is used to get the Hero object.
     *
     * @return the Hero object.
     */
    public static Object getHero() {
        return myHero;
    }

    /**
     * This method is used to set the Hero object.
     *
     * @param theHero is the Hero object.
     */
    public static void setHero(final Hero theHero) {
        myHero = theHero;
    }

    /**
     * This method is used to set the save current state.
     *
     * @param theSaveCurrentState is the current state of the game.
     */
    public static void setSaveCurrentState(final SaveCurrentState theSaveCurrentState) {
        mySaveCurrentState = theSaveCurrentState;
    }

    /**
     * This method is used to get the save current state.
     *
     * @return the current state of the game.
     */
    public static SaveCurrentState getSaveCurrentState() {
        return mySaveCurrentState;
    }

    /**
     * This method is used to set the save manager.
     *
     * @param theSaveManager is the save manager.
     */
    public static void setSaveManager(final SaveManager theSaveManager) {
        mySaveManager = theSaveManager;
    }

    /**
     * This method is used to get the save manager.
     *
     * @return the save manager.
     */
    public static SaveManager getSaveManager() {
        return mySaveManager;
    }

    /**
     * This method is used to set the input controls.
     *
     * @param theInputControls is the input controls.
     */
    public static void setInputControls(final InputControls theInputControls) {
        myInputControls = theInputControls;
    }

    /**
     * This method is used to get the input controls.
     *
     * @return the input controls.
     */
    public static InputControls getInputControls() {
        return myInputControls;
    }

    /**
     * This method is used draw the maze, the hero, and the maze mini map.
     *
     * @param theGraphics is the graphics object.
     */
    public static void draw(final Graphics2D theGraphics) {
        switch (Menus.getGameState()) {
            case "Maze":
                Maze.drawRoom(theGraphics);
                myHero.draw(theGraphics);
                Maze.drawMiniMap(theGraphics);
                break;
            case "Intro":
                Intro.draw(theGraphics);
                break;
            case "Battle":
                BattleView.draw(theGraphics);
            case "Dialogue", "Ending":
                break;
        }
    }

    /**
     * This method is used to update the hero.
     */
    public static void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (Menus.getGameState()) {
            case "Maze":
                myHero.update();
                break;
            case "Intro":
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intro.update();
                break;

            case "Battle":
            case "Dialogue", "Ending":
                break;
        }
    }

    /**
     * This method is used to set the maze.
     *
     * @param theMaze is the maze.
     */
    public static void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }

    /**
     * This method is used to get the maze.
     *
     * @return the maze.
     */
    public static Maze getMaze() {
        return myMaze;
    }

    public static void music() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (Menus.getGameState()) {
            case "Intro":
                SoundsPlay.playSongs(SoundsPlay.Song.OPENING);
                break;
            case "Maze":
                SoundsPlay.playSongs(SoundsPlay.Song.IN_GAME);
                break;
            case "Battle":
                SoundsPlay.playSongs(SoundsPlay.Song.IN_GAME);
                break;
            case "Dialogue", "Ending":
                SoundsPlay.playSongs(SoundsPlay.Song.THE_ONE_PIECE);
                break;
        }
    }
}