package com.company;

import com.company.data.DecKnapInstance;
import com.company.data.DecKnapInstanceW;
import com.company.gui.Presenter;
import com.company.io.FileReader;
import com.company.knap.DecKnapSolver;

import java.util.List;

public class Controller {
    protected static Presenter presenter;

    public Controller() {
        presenter = new Presenter();
        presenter.showMain();
    };

    public static void readFile(String filePath) {
        List<DecKnapInstance> instList = new FileReader<DecKnapInstance>().read(new DecKnapInstanceW(), filePath);
        for (DecKnapInstance i : instList) {
            System.out.println(new DecKnapSolver(i).solve());
        }
    }
}
