package com.example.application.ui.vertical.myProfile;

import com.example.application.backend.entity.Users;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.ui.MainView;


@Route(value = "myProfile", layout = MainView.class)
@PageTitle("Mein Profil")
public class MyProfileView extends Div {

    private Users user = new Users(1, "firstname", "surname", 3, "DE1273462537274", 'I', 5, 556434, "email", "wir sind toll" );

    public MyProfileView() {
        setId("myProfile-view");

        VerticalLayout content = new VerticalLayout();
        content.addComponentAsFirst(new Label("Mein Profil"));
        content.setSizeFull();
        content.getStyle().set("border", "2px solid #9E9E9E");
        content.addComponentAtIndex(1, initData());

        add(content);
    }

    private HorizontalLayout initData () {
        HorizontalLayout data = new HorizontalLayout();

        data.setWidth("100%");
        data.getStyle().set("text-align", "right");
        data.getStyle().set("border", "1px solid #9E9E9E");

        data.addComponentAsFirst(initVerticalLayoutLeft());
        data.addComponentAtIndex(1, initVerticalLayoutRight());

        return data;
    }

    private VerticalLayout initVerticalLayoutLeft () {
        VerticalLayout left = new VerticalLayout();

        HorizontalLayout name = new HorizontalLayout();
        HorizontalLayout emailPhone = new HorizontalLayout();
        HorizontalLayout centerRoom = new HorizontalLayout();

        TextField firstname = new TextField();
        firstname.setValue(user.getFirstname());
        firstname.setLabel("Vorname");
        firstname.setReadOnly(true);

        TextField surname = new TextField();
        surname.setValue(user.getSurname());
        surname.setLabel("Nachname");
        surname.setReadOnly(true);

        TextField email = new TextField();
        email.setValue(user.getEmail());
        email.setLabel("E-Mail");
        email.setReadOnly(true);

        TextField telephone = new TextField();
        telephone.setValue(user.getTelefon());
        telephone.setLabel("Telefonnummer");
        telephone.setReadOnly(true);

        TextField center = new TextField();
        center.setValue(user.getCenter());
        center.setLabel("Center");
        center.setReadOnly(true);

        TextField roomnumber = new TextField();
        roomnumber.setValue(user.getRoomnumber());
        roomnumber.setLabel("Raumnummer");
        roomnumber.setReadOnly(true);

        TextField address = new TextField();
        address.setValue(user.getAddressId());
        address.setLabel("Adresse");
        address.setReadOnly(true);

        TextField iban = new TextField();
        iban.setValue(user.getIban());
        iban.setLabel("Kontodaten");
        iban.setReadOnly(true);


        name.addComponentAsFirst(firstname);
        name.addComponentAtIndex(1, surname);
        left.addComponentAsFirst(name);

        emailPhone.addComponentAsFirst(email);
        emailPhone.addComponentAtIndex(1, telephone);
        left.addComponentAtIndex(1, emailPhone);

        centerRoom.addComponentAsFirst(center);
        centerRoom.addComponentAtIndex(1, roomnumber);
        left.addComponentAtIndex(2, centerRoom);

        left.addComponentAtIndex(3, address);

        left.addComponentAtIndex(4, iban);

        return left;
    }

    private VerticalLayout initVerticalLayoutRight () {
        VerticalLayout right = new VerticalLayout();

        Image profilepicture = new Image("images/user.png", "My Profile Picture");
        profilepicture.setHeight("auto");
        profilepicture.setWidth("15rem");
        profilepicture.addClassName("user");

        TextField jobDescription = new TextField();
        jobDescription.setValue(user.getJobDescription());
        jobDescription.setLabel("Tätigkeitsbeschreibung");
        jobDescription.setReadOnly(true);

        Button updateProfile = new Button("Profil bearbeiten", new Icon(VaadinIcon.PENCIL));
        updateProfile.addClickListener(e -> initContentDialog().open());
        updateProfile.setIconAfterText(true);


        right.addComponentAsFirst(profilepicture);
        right.addComponentAtIndex(1, jobDescription);
        right.addComponentAtIndex(2, updateProfile);

        return right;
    }

    private Dialog initContentDialog () {
        Dialog contentDialog = new Dialog();

        HorizontalLayout update = new HorizontalLayout();


        update.addComponentAsFirst(initUpdateVerticalLayoutLeft());
        update.addComponentAtIndex(1, initUpdateVerticalLayoutRight());
        contentDialog.add(new H1("Profil bearbeiten"), update);

        return contentDialog;
    }

    private VerticalLayout initUpdateVerticalLayoutLeft () {
        VerticalLayout updateLeft = new VerticalLayout();

        TextField updateIban = new TextField();
        updateIban.setValue(user.getIban());
        updateIban.setLabel("Kontodaten");

        TextArea updateJobDescription = new TextArea();
        updateJobDescription.setValue(user.getJobDescription());
        updateJobDescription.setLabel("Tätigkeitsbeschreibung");

        Button updateProfilpicture = new Button("Bild hochladen", new Icon(VaadinIcon.UPLOAD));
        updateProfilpicture.setIconAfterText(true);


        updateLeft.addComponentAsFirst(updateIban);
        updateLeft.addComponentAtIndex(1, updateJobDescription);
        updateLeft.addComponentAtIndex(2, updateProfilpicture);

        return updateLeft;
    }

    private VerticalLayout initUpdateVerticalLayoutRight () {
        VerticalLayout updateRight = new VerticalLayout();

        HorizontalLayout addressNumber = new HorizontalLayout();
        HorizontalLayout postcodeCity = new HorizontalLayout();

        TextField updateStreet = new TextField();
        updateStreet.setValue(user.getAddressId()); //address.getStreet...
        updateStreet.setLabel("Straße");

        IntegerField updateNumber = new IntegerField();
        updateNumber.setValue(12); //address.getNumber...
        updateNumber.setLabel("Hausnummer");

        IntegerField updatePostcode = new IntegerField();
        updatePostcode.setValue(29378); //address.getPostcode...
        updatePostcode.setLabel("PLZ");

        TextField updateCity = new TextField();
        updateCity.setValue(addressExample.getCity());
        updateCity.setLabel("Stadt");


        addressNumber.addComponentAsFirst(updateStreet);
        addressNumber.addComponentAtIndex(1,updateNumber);
        updateRight.addComponentAsFirst(addressNumber);

        postcodeCity.addComponentAsFirst(updatePostcode);
        postcodeCity.addComponentAtIndex(1, updateCity);
        updateRight.addComponentAtIndex(1, postcodeCity);

        return updateRight;
    }

}
