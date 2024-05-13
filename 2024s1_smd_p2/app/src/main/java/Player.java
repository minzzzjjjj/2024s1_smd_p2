import ch.aplu.jcardgame.*;
import ch.aplu.jgamegrid.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player {

    public abstract Card playCard(Hand hand, Random random);
}
