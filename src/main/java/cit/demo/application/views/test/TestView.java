package cit.demo.application.views.test;

import cit.demo.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Тестовое представление")
@Route(value = "test", layout = MainLayout.class)
public class TestView extends HorizontalLayout {

    public TestView() {

        Button button = getConfiguredButton();
        DatePicker datePicker = new DatePicker("Укажите дату");

        setVerticalComponentAlignment(Alignment.END, button, datePicker);

        add(button, datePicker);
    }
    
    private Button getConfiguredButton(){
        
        Button button = new Button("Нажми");
         button.addClickListener(event -> {
            add(new Text("Кнопка нажата"));
            Notification.show("Нажато!");
        });
         
         return button;
    }
}
