package cit.demo.application.views.contacts;

import cit.demo.application.data.SamplePerson;
import cit.demo.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "contact", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class ContactsView extends VerticalLayout {

    public ContactsView() {
        
        addClassName("list-view");
        setSizeFull();

        add(getToolbar(), getConfigureGrid());
    }

    private Grid<SamplePerson> getConfigureGrid() {
        
        Grid<SamplePerson> grid = new Grid<>(SamplePerson.class);
        
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email");
        grid.addColumn(contact -> contact.getRole()).setHeader("Статус");
        grid.addColumn(contact -> contact.getOccupation()).setHeader("Компания");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        
        return grid;
    }

    private HorizontalLayout getToolbar() {
        
        TextField filterText = new TextField();
        filterText.setPlaceholder("Фильтрация по имени...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Добавить контакт");

        var toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
