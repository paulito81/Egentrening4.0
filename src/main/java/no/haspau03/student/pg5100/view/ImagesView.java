package no.haspau03.student.pg5100.view;

/**
 * Created by Paul on 20.11.2015.
 */

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class ImagesView {

    private List<String> images;
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            images.add("westerdals"+ i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}