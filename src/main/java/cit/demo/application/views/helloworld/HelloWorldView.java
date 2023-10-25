package cit.demo.application.views.helloworld;

import cit.demo.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Привет Мир")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    public HelloWorldView() {
        TextField name = new TextField("Ваше имя");
        Button sayHello = getConfiguredButton(name.getValue());

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

    private Button getConfiguredButton(String text) {

        Button sayHello = new Button("Скажи привет");
        sayHello.addClickListener(cleckEvent -> {
            Notification.show("Привет " + text);
        });
        sayHello.addClickShortcut(Key.ENTER);

        return sayHello;
    }

}
