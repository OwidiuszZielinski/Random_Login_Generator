package com.example.application.views.inglogingenerator;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Random;


@Route(value = "", layout = MainLayout.class)
public class INGLoginGeneratorView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public INGLoginGeneratorView() {

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


                VerticalLayout centerLayout = new VerticalLayout(header,nameField, surnameField, addButton,result);
                centerLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);


                addButton.addClickListener(event -> {
                    String name = nameField.getValue();
                    String surname = surnameField.getValue();

                    if (!name.isEmpty() && !surname.isEmpty()) {
                        String message = "Generated";
                        Notification.show(message, 3000, Notification.Position.BOTTOM_END);
                        result.setValue(usernameGenerator(name,surname));
                        // You can perform additional actions here, such as storing the data in a database.
                    } else {
                        Notification.show("Please enter both a name and a surname.", 3000, Notification.Position.MIDDLE);
                    }
                });
                addButton.addClickShortcut(Key.ENTER);



                add(
                        
                        centerLayout
                );

            }

            public static String usernameGenerator(String name,String surname){
                String result = name.substring(0, 3) +
                        surname.substring(0, 3) +
                        new Random().nextInt(1000, 9999);
                return result.toLowerCase();
            }
        }
