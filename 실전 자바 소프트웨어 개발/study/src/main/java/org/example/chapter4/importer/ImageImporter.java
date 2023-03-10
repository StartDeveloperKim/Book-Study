package org.example.chapter4.importer;

import org.example.chapter4.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.example.chapter4.importer.Attributes.*;

public class ImageImporter implements Importer{
    @Override
    public Document importFile(final File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH.getName(), file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH.getName(), String.valueOf(image.getWidth()));
        attributes.put(HEIGHT.getName(), String.valueOf(image.getHeight()));
        attributes.put(TYPE.getName(), "IMAGE");
        return null;
    }
}
