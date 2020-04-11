package service;
import domain.Gesture;

import java.util.Optional;
public interface RulesEngine {
	Optional<Gesture> applyRules(Gesture p1Gesture, Gesture p2Gesture);
}
