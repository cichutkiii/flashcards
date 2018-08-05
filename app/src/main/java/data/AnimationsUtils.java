package data;

import java.util.ArrayList;
import java.util.List;

import pl.preclaw.fiche.R;

public class AnimationsUtils {
    public List<Integer> getAnimationsList() {
        return animationsList;
    }

    public void setAnimationsList(List<Integer> animationsList) {
        this.animationsList = animationsList;
    }

    private List<Integer> animationsList = new ArrayList<>();
    public AnimationsUtils() {
        animationsList.add(R.anim.intro_anim3);
        animationsList.add(R.anim.intro_anim4);
        animationsList.add(R.anim.intro_anim5);
        animationsList.add(R.anim.intro_anim6);
        animationsList.add(R.anim.intro_anim7);
        animationsList.add(R.anim.intro_anim8);
        animationsList.add(R.anim.intro_anim9);
        animationsList.add(R.anim.intro_anim10);
        animationsList.add(R.anim.intro_anim11);
        animationsList.add(R.anim.intro_anim12);
        animationsList.add(R.anim.intro_anim13);
        animationsList.add(R.anim.fade_in1);


    }


}
