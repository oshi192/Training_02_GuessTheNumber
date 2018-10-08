package mvc;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(){
        model = new GameModel();
        view = new GameView();
    }

    public void start(){
        view.printStartMessage(model.getMin(),model.getMax());
        model.createNumber();
        while (model.getAnswer() != model.getAskNumer()) {
            view.printStatusBar(model.getMin(),model.getMax(),model.getRange());
            model.compareNumbers();
        }
        view.printFinishMessage();
        view.printStatistics(model.getInputs());
    }
}
