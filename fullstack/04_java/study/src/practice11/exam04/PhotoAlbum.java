package practice11.exam04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class PhotoAlbum {
    private List<Photo> album = new ArrayList<>();

    void addPhoto(Photo photo, Consumer<Photo> consumer) {
        consumer.accept(photo);
        album.add(photo);
    }

    void printFiltered(Predicate<Photo> filter, Consumer<Photo> printer) {
        for (Photo photo : album) {
            if (filter.test(photo)) printer.accept(photo);
        }
    }
}
