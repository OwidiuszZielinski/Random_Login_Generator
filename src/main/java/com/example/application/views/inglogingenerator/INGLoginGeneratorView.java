package com.example.application.views.inglogingenerator;

import com.example.application.GeneratedUser;
import com.example.application.UserDTO;
import com.example.application.UserService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Random;


@Route(value = "", layout = MainLayout.class)
public class INGLoginGeneratorView extends HorizontalLayout {

    private final UserService service;


    public INGLoginGeneratorView(UserService service) {
        this.service = service;

        TextField nameField = new TextField("Name");
        //<theme-editor-local-classname>
        nameField.addClassName("i-ng-login-generator-view-text-field-1");
        TextField surnameField = new TextField("Surname");
        //<theme-editor-local-classname>
        surnameField.addClassName("i-ng-login-generator-view-text-field-2");
        Button addButton = new Button("Generate");
        //<theme-editor-local-classname>
        addButton.addClassName("i-ng-login-generator-view-button-1");
        TextField result = new TextField("Your Username : ");
        H1 header = new H1("ING Login Generator");
        //<theme-editor-local-classname>
        header.addClassName("i-ng-login-generator-view-h1-1");


        VerticalLayout centerLayout = new VerticalLayout(header, nameField, surnameField, addButton, result);
        centerLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        Grid<GeneratedUser> grid = new Grid<>(GeneratedUser.class, false);
        grid.addColumn(GeneratedUser::getId).setHeader("ID");
        grid.addColumn(GeneratedUser::getName).setHeader("Name");
        grid.addColumn(GeneratedUser::getSurname).setHeader("Surname");
        grid.addColumn(GeneratedUser::getUsername).setHeader("Username");
        grid.addClassName("vaadin-grid");

        List<GeneratedUser> users = service.getUsers();
        grid.setItems(users);
        VerticalLayout gridLayout = new VerticalLayout(grid);


        addButton.addClickListener(event -> {
            String name = nameField.getValue();
            String surname = surnameField.getValue();

            if (!name.isEmpty() && !surname.isEmpty()) {
                String message = "Generated";
                Notification.show(message, 3000, Notification.Position.BOTTOM_END);
                String value = usernameGenerator(name, surname);
                result.setValue(value);
                service.addUser(new UserDTO(name, surname, value));
                updateList(grid);
                // You can perform additional actions here, such as storing the data in a database.
            } else {
                Notification.show("Please enter both a name and a surname.", 3000, Notification.Position.MIDDLE);
            }

        });
        addButton.addClickShortcut(Key.ENTER);


        add(
                centerLayout
                ,gridLayout
        );


    }

    public static String usernameGenerator(String name, String surname) {
        String result = name.substring(0, 3) +
                surname.substring(0, 3) +
                new Random().nextInt(1000, 9999);
        return result.toLowerCase();
    }

    private void updateList(Grid<GeneratedUser> grid) {
        grid.setItems(service.getUsers());
    }
}
