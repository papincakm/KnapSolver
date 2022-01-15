package com.company.controllers;

import com.company.data.*;
import com.company.io.FileEditor;
import com.company.io.FileReader;
import com.company.io.KnapInstanceEditor;
import com.company.knap.SolverFactory;

import java.util.List;
interface JobRunner {
    public void run(Job job);
}
