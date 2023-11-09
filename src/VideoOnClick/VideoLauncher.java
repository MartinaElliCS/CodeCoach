package VideoOnClick;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class VideoLauncher{
    static Desktop d = Desktop.getDesktop();

    public void openYoutubeLink() throws IOException {
        try {
            d.browse(new URI("https://youtu.be/QMbx0dTWJIQ?si=Wyv3Djji50sMfN4N?autoplay=1&mute=0"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
