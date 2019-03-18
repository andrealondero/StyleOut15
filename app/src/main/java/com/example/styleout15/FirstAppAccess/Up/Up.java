package com.example.styleout15.FirstAppAccess.Up;

import com.example.styleout15.R;

import java.util.ArrayList;
import java.util.List;

public class Up {

    private int modelUpImage;
    private List<Integer> lstUp = new ArrayList<>();
    private List<Integer> typeUp = new ArrayList<>();

    public List<Integer> getLstUp() { return lstUp;
    }

    public void setLstUp(List<Integer> lstUp) { this.lstUp = lstUp;
    }

    public List<Integer> getTypeUp() { return typeUp;
    }

    public void setTypeUp(List<Integer> typeUp) { this.typeUp = typeUp;
    }

    public Up() {

        lstUp.add(R.drawable.blues);
        lstUp.add(R.drawable.blues_one);
        lstUp.add(R.drawable.blues_two);
        lstUp.add(R.drawable.blues_three);
        lstUp.add(R.drawable.blues_four);
        lstUp.add(R.drawable.blues_five);
        lstUp.add(R.drawable.polo);
        lstUp.add(R.drawable.polo_one);
        lstUp.add(R.drawable.polo_two);
        lstUp.add(R.drawable.polo_three);
        lstUp.add(R.drawable.polo_four);
        lstUp.add(R.drawable.polo_five);
        lstUp.add(R.drawable.tshirt);
        lstUp.add(R.drawable.tshirt_one);
        lstUp.add(R.drawable.tshirt_two);
        lstUp.add(R.drawable.tshirt_three);
        lstUp.add(R.drawable.canotta);
        lstUp.add(R.drawable.canotta_1);
        lstUp.add(R.drawable.canotta_2);

        typeUp.add(101);
        typeUp.add(102);
        typeUp.add(103);
        typeUp.add(104);
        typeUp.add(105);
        typeUp.add(106);
        typeUp.add(107);
        typeUp.add(108);
        typeUp.add(109);
        typeUp.add(110);
        typeUp.add(111);
        typeUp.add(112);
        typeUp.add(113);
        typeUp.add(114);
        typeUp.add(115);
        typeUp.add(116);
        typeUp.add(117);
        typeUp.add(118);
        typeUp.add(119);
    }

    public Up(int modelUpImage) {
        this.modelUpImage = modelUpImage;
    }

    public int getModelUpImage() {
        return modelUpImage;
    }

    public void setModelUpImage(int modelUpImage) {
        this.modelUpImage = modelUpImage;
    }
}
