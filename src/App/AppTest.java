package App;

import UI.MineSweeperFrame;
public class AppTest{
    public static void main(String[] args) {
        MineSweeperFrame mineSweeperFrame = MineSweeperFrame.getInstance();
        mineSweeperFrame.showSettingsPanel();
        mineSweeperFrame.play();
    }
}
