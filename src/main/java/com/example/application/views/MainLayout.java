package com.example.application.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Random;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {



    public MainLayout() {
        setPrimarySection(Section.DRAWER);

        //<theme-editor-local-classname>
        addClassName("main-layout-app-layout-1");
    }

}