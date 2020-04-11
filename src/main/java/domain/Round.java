package domain;
import service.RulesEngine;
import java.util.Optional;
public class Round {
	private final Player p1;
    private final Player p2;
    private final Player p3;
    private final Player p4;
    private final Gesture p1Gesture;
    private final Gesture p2Gesture;
    private final Gesture p3Gesture;
    private final Gesture p4Gesture;
    private final RulesEngine rulesEngine;
    private RoundResult result;

    public Round(Player p1, Player p2,Player p3, Player p4, RulesEngine rulesEngine) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p1Gesture = p1.doGesture();
        this.p2Gesture = p2.doGesture();
        this.p3Gesture = p3.doGesture();
        this.p4Gesture = p4.doGesture();
        this.rulesEngine = rulesEngine;

        evaluate();
    }


    private void  evaluate() {
        Optional<Gesture> winningGesture = rulesEngine.applyRules(p1Gesture, p2Gesture);

        if(winningGesture.isPresent())
            result =  RoundResult.resolved(getPlayerFor(winningGesture.get()));
        else
            result = RoundResult.draw();
    }

    private Player getPlayerFor(Gesture gesture) {
         if(gesture.equals(p1Gesture))
             return p1;
        else
            return p2;

    }

    public RoundResult getResult() {
        return result;
    }

    public Player getPlayer1() {
        return p1;
    }

    public Player getPlayer2() {
        return p2;
    }
    public Player getPlayer3() {
        return p3;
    }

    public Player getPlayer4() {
        return p4;
    }

    public Gesture getP1Gesture() {
        return p1Gesture;
    }

    public Gesture getP2Gesture() {
        return p2Gesture;
    }
    public Gesture getP3Gesture() {
        return p3Gesture;
    }

    public Gesture getP4Gesture() {
        return p4Gesture;
    }
}
