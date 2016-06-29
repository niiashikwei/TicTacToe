
public class GameOverConditions {
    private GameOverCondition[] conditions;

    public GameOverConditions(GameOverCondition... conditions) {
        this.conditions = conditions;
    }

    public boolean isGameOver(){
        for(GameOverCondition condition : conditions){
            if(condition.evaluate()) return true;
        }
        return false;
    }
}
