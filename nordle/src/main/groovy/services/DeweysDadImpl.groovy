package services

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

/**
 * Created by mcmahok8 on 30/12/2014.
 */
@Service
@Component

class DeweysDadImpl implements DeweysDad{
    private static String theWrongKid = "Nate"
    private static String theRightKid = "Dewey"
    @Override
    boolean didTheWrongKidDie(String name) {
        if(name.equals(theWrongKid)){
            true
        }else false
    }

}
