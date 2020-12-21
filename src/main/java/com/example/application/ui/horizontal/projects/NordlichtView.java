package com.example.application.ui.horizontal.projects;

import com.example.application.ui.ContentHolder;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.ui.MainView;

@Route(value = "nordlicht", layout = ContentHolder.class)
@PageTitle("Nordlicht")
public class NordlichtView extends Div {

    public NordlichtView() {
        setId("nordlicht-view");
        setClassName("pageContentPosition");
        add(new Text("Nordlicht"));
    }

}
