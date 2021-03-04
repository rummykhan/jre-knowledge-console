package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import org.jsoup.nodes.Element;

public class ImageParser {

    public String parse(@NonNull Element imageTag) {

        String srcSet = imageTag.attr("srcset");

        String[] images = srcSet.split(", ");

        String bigImage = getImage(images, "640w");
        if (bigImage != null) {
            return bigImage.trim();
        }

        String mediumImage = getImage(images, "320w");
        if (mediumImage != null) {
            return mediumImage.trim();
        }

        String smallMediumImage = getImage(images, "300w");
        if (smallMediumImage != null) {
            return smallMediumImage.trim();
        }

        String smallImage = getImage(images, "150w");
        if (smallImage != null) {
            return smallImage.trim();
        }

        return null;
    }

    public String getImage(@NonNull String[] images, @NonNull String dimension) {

        for (String image : images) {
            if (image.contains(dimension)) {
                return image.replace(dimension, "");
            }
        }

        return null;
    }
}
