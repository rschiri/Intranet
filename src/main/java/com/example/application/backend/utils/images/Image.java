package com.example.application.backend.utils.images;

import com.example.application.backend.entities.ImageEntity;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;


/**
 * This class represents an image component, it receives an imageEntity and
 * the files input stream.
 *
 * @author  Anastasiya Jackwerth, Sabrine Gamdou, Jessica Reistel, Monika Martius
 * @version 3.0
 * @since   21.12.2020
 * @lastUpdated 01.02.2021 from Jessica Reistel, Monika Martius
 */

public class Image extends Div {
    private ImageEntity imageEntity;

    private Icon deleteButton;
    private Component imageViewer;
    private StreamResource stream; //Is it used?
    private int role;

    private InputStream inputStream;



    public Image(ImageEntity imageEntity, InputStream inputStream, int role){
        this.imageEntity = imageEntity;
        this.inputStream = inputStream;
        this.role = role;

        initializePDF();

    }

    public void initializePDF(){
        deleteButton = new Icon(VaadinIcon.TRASH);
        initializeImageViewer();
        if(role == 1){
            this.add(deleteButton);
        }
        this.add(imageViewer);
    }

    public void initializeImageViewer(){
        imageViewer = new ImageViewer(new StreamResource(imageEntity.getFileName(), () -> {

            try {
                System.out.println("PATH: "+ imageEntity.getPath());
                return new FileInputStream(imageEntity.getPath());
            } catch (Exception e) {
                return new ByteArrayInputStream(new byte[]{});
            }
        }));


    }


    public Icon getDeleteButton() {
        return deleteButton;
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}

