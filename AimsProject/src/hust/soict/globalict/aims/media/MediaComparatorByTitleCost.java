package hust.soict.globalict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare (Media o1, Media o2) {
        if (Objects.equals(o1.getTitle(), o2.getTitle())) {
            return Float.compare(o1.getCost(), o2.getCost());
        }
        else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
