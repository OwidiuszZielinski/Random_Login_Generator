package com.example.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {



    public MainLayout() {
        setPrimarySection(Section.DRAWER);

        //<theme-editor-local-classname>
        addClassName("main-layout-app-layout-1");

        VerticalLayout list = new VerticalLayout();

    }

}